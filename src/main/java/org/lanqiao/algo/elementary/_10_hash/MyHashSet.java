package org.lanqiao.algo.elementary._10_hash;

import java.util.Iterator;

public class MyHashSet<E> implements IHashSet<E> {
  private MyHashMap<E, E> map = new MyHashMap<>();

  @Override
  public void add(E key) {
    map.put(key, null);
  }

  @Override
  public void remove(E key) {
    map.remove(key);
  }

  @Override
  public void clear() {
    map.clear();
  }

  @Override
  public boolean contains(E key) {
    return map.containsKey(key);
  }

  @Override
  public boolean isEmpty() {
    return map.isEmpty();
  }

  @Override
  public int size() {
    return map.size();
  }

  @Override
  public Iterator<E> iterator() {
    Iterator<MyHashMap.Node> iter = map.iterator();
    return new Iterator<E>() {
      @Override
      public boolean hasNext() {
        return iter.hasNext();
      }

      @Override
      public E next() {
        return (E) iter.next().key;
      }
    };
  }

  @Override
  public String toString() {
    Iterator<MyHashMap.Node> iterator = map.iterator();
    StringBuilder sb = new StringBuilder();
    while (iterator.hasNext()) {
      sb.append(iterator.next().key + ",");
    }
    return sb.toString();
  }
}
