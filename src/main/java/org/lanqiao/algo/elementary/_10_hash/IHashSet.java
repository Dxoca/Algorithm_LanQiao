package org.lanqiao.algo.elementary._10_hash;

import java.util.Iterator;

public interface IHashSet<E> {
  void add(E key);

  void remove(E key);

  void clear();

  boolean contains(E key);

  boolean isEmpty();

  int size();

  Iterator<E> iterator();
}
