package org.lanqiao.algo.elementary._10_hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/*不考虑数据倾斜*/
public class ConsistentHashing1 {
  //hash算法，将关键字映射到2^32的环状空间里面
  static long hash(String key) {
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
    return Math.abs(h);

  }

  //机器节点==网络节点
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

  //  节点列表
  List<Node> nodes;
  TreeMap<Long, Node> hashAndNode = new TreeMap<>();
  TreeMap<Long, Node> keyAndNode = new TreeMap<>();

  public ConsistentHashing1(List<Node> nodes) {
    this.nodes = nodes;
    init();
  }

  private void init() {
    for (int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      long hash = hash(node.ip);
      hashAndNode.put(hash, node);
    }
  }

  private void add(String key) {
    long hash = hash(key);
    SortedMap<Long, Node> subMap = hashAndNode.tailMap(hash);//找到map中key比fromKey大的所有的键值对，组成一个子Map
    if (subMap.size() == 0) {
      keyAndNode.put(hash, hashAndNode.firstEntry().getValue());
    } else {
      Node node = subMap.get(subMap.firstKey());//第一个节点，key应该归属的节点
      keyAndNode.put(hash, node);
    }
  }

  /**
   * 增加一个新的机器节点
   * @param newNode
   */
  private void add(Node newNode) {
    long hash = hash(newNode.ip);
    hashAndNode.put(hash, newNode);
    //  数据迁移
    SortedMap<Long, Node> pre = hashAndNode.headMap(hash);//key小于hash的子map
    if (pre.size() == 0) {
      SortedMap<Long, Node> between = keyAndNode.subMap(0L, hash);
      for (Map.Entry<Long, Node> e : between.entrySet()) {
        e.setValue(newNode);
      }
      between = keyAndNode.tailMap(hashAndNode.lastKey());
      for (Map.Entry<Long, Node> e : between.entrySet()) {
        e.setValue(newNode);
      }
    } else {
      long from = pre.lastKey();
      long to = hash;
      SortedMap<Long, Node> between = keyAndNode.subMap(from, to);
      for (Map.Entry<Long, Node> e : between.entrySet()) {
        e.setValue(newNode);
      }
    }
  }

  public static void main(String[] args) {
    List<Node> nodes = new ArrayList<>();
    nodes.add(new Node("node1", "192.168.1.2"));
    nodes.add(new Node("node2", "192.168.1.3"));
    nodes.add(new Node("node3", "192.168.1.4"));
    nodes.add(new Node("node4", "192.168.1.5"));
    nodes.add(new Node("node5", "192.168.1.6"));
    ConsistentHashing1 obj = new ConsistentHashing1(nodes);
    for (Map.Entry<Long, Node> entry :
        obj.hashAndNode.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue().getName());
    }
    obj.add("a");
    obj.add("b");
    obj.add("c");
    obj.add("e");
    obj.add("zhangsan");
    obj.add("lisi");
    obj.add("wangwu");
    obj.add("zhaoliu");
    obj.add("wangchao");
    obj.add("mahan");
    obj.add("zhanglong");
    obj.add("zhaohu");
    obj.add("baozheng");
    obj.add("gongsun");
    obj.add("zhanzhao");
    for (Map.Entry<Long, Node> entry :
        obj.keyAndNode.entrySet()) {
      System.out.println(entry.getKey() + " ,归属到:" + entry.getValue().getName());
    }
    System.out.println("===========");
    obj.add(new Node("node6", "192.168.1.77"));
    for (Map.Entry<Long, Node> entry :
        obj.keyAndNode.entrySet()) {
      System.out.println(entry.getKey() + " ,归属到:" + entry.getValue().getName());
    }
  }
}
