package org.lanqiao.algo.elementary._10_hash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;
import java.util.ArrayList;

/**
 * 一致性hash算法
 * */
public class ConsistentHashing<N extends ConsistentHashing.HashNode> { // S类封装了机器节点的信息 ，如name、password、ip、port等
  private Logger logger = LoggerFactory.getLogger(getClass());
  private TreeMap<Long, N> vNodeAndRealNode; // 虚拟节点到真实节点的映射
  private TreeMap<Long, N> keyAndRealNode; //key到真实节点的映射
  private List<N> nodes = new java.util.ArrayList<N>(); // 真实机器节点
  private final int V_NODE_NUM = 100; // 每个机器节点关联的虚拟节点个数
  boolean flag = false;

  public ConsistentHashing(List<N> nodes) {
    super();
    this.nodes = nodes;
    init();
  }

  public static void main(String[] args) {
//		logger.debug(hash("w222o1d"));
//		logger.debug(Long.MIN_VALUE);
//		logger.debug(Long.MAX_VALUE);
    Node s1 = new Node("s1", "192.168.1.1");
    Node s2 = new Node("s2", "192.168.1.2");
    Node s3 = new Node("s3", "192.168.1.3");
    Node s4 = new Node("s4", "192.168.1.4");
    Node s5 = new Node("s5", "192.168.1.5");
    List<Node> nodes = new ArrayList<>(100);
    nodes.add(s1);
    nodes.add(s2);
    nodes.add(s3);
    nodes.add(s4);

    ConsistentHashing<Node> sh = new ConsistentHashing<>(nodes);
    sh.keyToNode("101客户端");
    sh.keyToNode("102客户端");
    sh.keyToNode("103客户端");
    sh.keyToNode("104客户端");
    sh.keyToNode("105客户端");
    sh.keyToNode("106客户端");
    sh.keyToNode("107客户端");
    sh.keyToNode("108客户端");
    sh.keyToNode("109客户端");

    sh.deleteNode(s2);


    sh.addNode(s5);

    // logger.debug("最后的客户端到主机的映射为：");
    sh.printKeyTree();
  }

  public void printKeyTree() {
    logger.debug("当前映射信息为：");
    for (Iterator<Long> it = keyAndRealNode.keySet().iterator(); it.hasNext(); ) {
      Long lo = it.next();
      logger.debug("hash(" + lo + ")连接到主机->" + keyAndRealNode.get(lo));
    }

  }

  private void init() { // 初始化一致性hash环
    vNodeAndRealNode = new TreeMap<Long, N>();
    keyAndRealNode = new TreeMap<Long, N>();
    for (int i = 0; i != nodes.size(); ++i) { // 每个真实机器节点都需要关联虚拟节点
      final N shardInfo = nodes.get(i);

      for (int n = 0; n < V_NODE_NUM; n++)
        // 一个真实机器节点关联NODE_NUM个虚拟节点
        vNodeAndRealNode.put(hash("SHARD-" + shardInfo.getName() + "-NODE-" + n), shardInfo);
    }
  }

  //增加一个主机
  public void addNode(N s) {
    logger.debug("增加主机" + s + "的变化：");
    for (int n = 0; n < V_NODE_NUM; n++)
      addNode(hash("SHARD-" + s.getName() + "-NODE-" + n), s);

  }

  //添加一个虚拟节点进环形结构,lg为虚拟节点的hash值
  private void addNode(Long lg, N s) {
    SortedMap<Long, N> tail = vNodeAndRealNode.tailMap(lg);
    SortedMap<Long, N> head = vNodeAndRealNode.headMap(lg);
    Long begin = 0L;
    Long end = 0L;
    SortedMap<Long, N> between;
    if (head.size() == 0) {
      between = keyAndRealNode.tailMap(vNodeAndRealNode.lastKey());
      flag = true;
    } else {
      begin = head.lastKey();
      between = keyAndRealNode.subMap(begin, lg);
      flag = false;
    }
    vNodeAndRealNode.put(lg, s);
    for (Iterator<Long> it = between.keySet().iterator(); it.hasNext(); ) {
      Long lo = it.next();
      if (flag) {
        keyAndRealNode.put(lo, vNodeAndRealNode.get(lg));
        logger.debug("hash(" + lo + ")改变到->" + tail.get(tail.firstKey()));
      } else {
        keyAndRealNode.put(lo, vNodeAndRealNode.get(lg));
        logger.debug("hash(" + lo + ")改变到->" + tail.get(tail.firstKey()));
      }
    }
  }

  //删除真实节点是s
  public void deleteNode(N s) {
    if (s == null) {
      return;
    }
    logger.debug("删除主机" + s + "的变化：");
    for (int i = 0; i < V_NODE_NUM; i++) {
      //定位s节点的第i的虚拟节点的位置
      SortedMap<Long, N> tail = vNodeAndRealNode.tailMap(hash("SHARD-" + s.getName() + "-NODE-" + i));
      SortedMap<Long, N> head = vNodeAndRealNode.headMap(hash("SHARD-" + s.getName() + "-NODE-" + i));
      Long begin = 0L;
      Long end = 0L;

      SortedMap<Long, N> between;
      if (head.size() == 0) {
        between = keyAndRealNode.tailMap(vNodeAndRealNode.lastKey());
        end = tail.firstKey();
        tail.remove(tail.firstKey());
        vNodeAndRealNode.remove(tail.firstKey());//从nodes中删除s节点的第i个虚拟节点
        flag = true;
      } else {
        begin = head.lastKey();
        end = tail.firstKey();
        tail.remove(tail.firstKey());
        between = keyAndRealNode.subMap(begin, end);//在s节点的第i个虚拟节点的所有key的集合
        flag = false;
      }
      for (Iterator<Long> it = between.keySet().iterator(); it.hasNext(); ) {
        Long lo = it.next();
        if (flag) {
          keyAndRealNode.put(lo, tail.get(tail.firstKey()));
          logger.debug("hash(" + lo + ")改变到->" + tail.get(tail.firstKey()));
        } else {
          keyAndRealNode.put(lo, tail.get(tail.firstKey()));
          logger.debug("hash(" + lo + ")改变到->" + tail.get(tail.firstKey()));
        }
      }
    }

  }

  //映射key到真实节点
  public void keyToNode(String key) {
    SortedMap<Long, N> tail = vNodeAndRealNode.tailMap(hash(key)); // 沿环的顺时针找到一个虚拟节点
    if (tail.size() == 0) {
      return;
    }
    Long virtualNodeKey = tail.firstKey();
    N realNode = tail.get(virtualNodeKey);
    keyAndRealNode.put(hash(key), realNode);
    logger.debug(key + "（hash：" + hash(key) + "）连接到主机->" + realNode);
  }

  /**
   *  MurMurHash算法，是非加密HASH算法，性能很高，
   *  比传统的CRC32,MD5，SHA-1（这两个算法都是加密HASH算法，复杂度本身就很高，带来的性能上的损害也不可避免）
   *  等HASH算法要快很多，而且据说这个算法的碰撞率很低.
   *  http://murmurhash.googlepages.com/
   */
  private static Long hash(String key) {

    ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
    int seed = 0x1234ABCD;

    ByteOrder byteOrder = buf.order();
    buf.order(ByteOrder.LITTLE_ENDIAN);

    long m = 0xc6a4a7935bd1e995L;
    int r = 47;

    long h = seed ^ (buf.remaining() * m);

    long k;
    while (buf.remaining() >= 8) {
      k = buf.getLong();

      k *= m;
      k ^= k >>> r;
      k *= m;

      h ^= k;
      h *= m;
    }

    if (buf.remaining() > 0) {
      ByteBuffer finish = ByteBuffer.allocate(8).order(
          ByteOrder.LITTLE_ENDIAN);
      // for big-endian version, do this first:
      // finish.position(8-buf.remaining());
      finish.put(buf).rewind();
      h ^= finish.getLong();
      h *= m;
    }

    h ^= h >>> r;
    h *= m;
    h ^= h >>> r;

    buf.order(byteOrder);
    return h;
  }

  static class Node implements HashNode {
    String name;
    String ip;

    public Node(String name, String ip) {
      this.name = name;
      this.ip = ip;
    }

    @Override
    public String toString() {
      return this.name + "-" + this.ip;
    }

    @Override
    public String getName() {
      return name;
    }
  }

  interface HashNode {
    String getName();
  }

}