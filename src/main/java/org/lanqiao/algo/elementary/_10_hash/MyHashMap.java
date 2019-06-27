package org.lanqiao.algo.elementary._10_hash;

import java.util.Iterator;

public class MyHashMap<K, V> implements IMap<K, V> {
  private int length = 16;

  private Node[] buckets = new Node[length];//桶
  private int size;

  @Override
  public void clear() {
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = null;
    }
  }

  @Override
  public boolean containsKey(K key) {
    int index = hash1(key);
    if (buckets[index] == null) {
      return false;
    } else {
      Node<K, V> p = buckets[index];//相当于在链表中找key
      while (p != null) {
        K k1 = p.key;
        //借用java机制，hashcode和equals都来自于Object，用户可以改写这两个方法——制定对象相等的规则
        if (k1 == key || (k1.hashCode() == key.hashCode() && k1.equals(key))) {
          return true;
        }
        p = p.next;
      }
    }

    return false;
  }

  @Override
  public boolean containsValue(V value) {
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] != null) {
        Node<K, V> p = buckets[i];
        while (p != null) {
          if (p.value.equals(value))
            return true;
        }
      }
    }
    return false;
  }

  @Override
  public V get(K key) {
    int index = hash1(key);
    if (buckets[index] == null) {
      return null;
    } else {
      Node<K, V> p = buckets[index];
      while (p != null) {
        K k1 = p.key;
        if (k1 == key || (k1.hashCode() == key.hashCode() && k1.equals(key))) {
          return p.value;
        }
        p = p.next;
      }
    }
    return null;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public MyHashSet<K> keySet() {
    MyHashSet<K> set = new MyHashSet<>();
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] != null) {
        Node<K, V> p = buckets[i];
        while (p != null) {
          set.add(p.key);
          p = p.next;
        }
      }
    }
    return set;
  }

  @Override
  public void put(K key, V value) {
    Node<K, V> node = new Node<>(key, value);
    int index = hash1(key);//算出在桶中的位置
    if (buckets[index] == null) {//桶中没有东西
      buckets[index] = node;
      size++;
    } else {
      Node<K, V> p = buckets[index];//链表的表头找到
      while (p != null) {
        K k1 = p.key;
        if (key == k1 || key.hashCode() == k1.hashCode() && key.equals(k1)) {
          p.value = value;//存在相同的key，则更新value
          break;
        }
        if (p.next == null) {
          p.next = node;
          size++;
          break;
        }
        p = p.next;
      }

    }
  }

  private int hash1(K key) {
    // return key.hashCode() % length;
    int h = 0;
    int seed = 31;//素数
    String s = key.toString();
    for (int i = 0; i != s.length(); ++i) {
      h = seed * h + s.charAt(i);
    }
    return h % length;
  }

  @Override
  public void putAll(IMap<? extends K, ? extends V> map) {

  }

  @Override
  public V remove(K key) {
    int index = hash1(key);//先定桶的位置
    if (buckets[index] == null) {
      return null;
    } else {
      Node<K, V> p = buckets[index];//找到表头
      Node<K, V> pre = p;

      while (p != null) {
        K k1 = p.key;
        if (k1.hashCode() == key.hashCode() && k1.equals(key)) {
          //移除
          if (p == pre) {
            buckets[index] = pre.next;
          } else {
            pre.next = p.next;
          }
          size--;
          return p.value;
        }
        pre = p;
        p = p.next;
      }
    }
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public V[] values() {
    return null;
  }

  private class MapInterator implements Iterator<Node> {
    int i = 0;
    Node p = buckets[0];

    @Override
    public boolean hasNext() {
      while (this.i < length && p == null) {
        this.i++;
        if (this.i == length)
          p = null;
        else
          p = buckets[this.i];
      }
      //i是一个非空的桶，p是链表头
      return p != null;
    }

    @Override
    public Node next() {
      Node res = p;
      p = p.next;
      return res;
    }
  }

  @Override
  public Iterator<Node> iterator() {
    return new MapInterator();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < buckets.length; i++) {
      if (buckets[i] != null) {
        Node<K, V> p = buckets[i];
        while (p != null) {
          sb.append("(" + p.key + "," + p.value + "),");
          p = p.next;
        }
      }
    }
    return sb.toString();
  }

  public class Node<K, V> {
    public K key;
    public V value;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }

    private Node next;

    @Override
    public String toString() {
      return "BSTNode{" +
          "key=" + key +
          ", value=" + value +
          '}';
    }
  }
}
