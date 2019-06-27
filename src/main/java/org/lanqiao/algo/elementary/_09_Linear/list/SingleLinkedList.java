package org.lanqiao.algo.elementary._09_Linear.list;

public class SingleLinkedList implements MyList {
  private ListNode first;
  private ListNode last;
  private int size;

  @Override
  public void add(Object element) {
    if (first == null) {
      first = new ListNode(element);
      last = first;
    } else {
      last.next = new ListNode(element);
      last = last.next;
    }
    size++;
  }

  @Override
  public void delete(Object element) {
    ListNode p = first;
    ListNode pre = null;
    while (p != null) {
      if (p.data.equals(element)) {
        if (p == first)
          first = first.next;
        else
          pre.next = p.next;
        size--;
        break;//注意这里
      }
      pre = p;
      p = p.next;
    }
  }

  @Override
  public void delete(int index) {
    if (index < 0 || index >= size) {
      return;//啥也不干
    }
    int i = 0;//指针指向的节点的索引
    ListNode p = first;
    ListNode pre = null;

    while (p != null) {
      if (i == index) {
        if (p == first)
          first = first.next;
        else
          pre.next = p.next;
        break;//注意这里
      }
      pre = p;
      p = p.next;
      i++;
    }
    size--;
  }

  @Override
  public void update(int index, Object newElement) {
    if (index < 0 || index >= size) {
      return;//啥也不干
    }
    int i = 0;//指针指向的节点的索引
    ListNode p = first;

    while (p != null) {
      if (i == index) {
        p.data = newElement;
      }
      p = p.next;
      i++;
    }
  }

  @Override
  public boolean contains(Object target) {
    ListNode p = first;
    while (p != null) {
      if (p.data.equals(target)) {
        return true;
      }
      p = p.next;
    }
    return false;
  }

  @Override
  public Object at(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    int i = 0;//指针指向的节点的索引
    ListNode p = first;

    while (p != null) {
      if (i == index) {
        return p.data;
      }
      p = p.next;
      i++;
    }
    return null;
  }

  @Override
  public int indexOf(Object element) {
    int i = 0;//指针指向的节点的索引
    ListNode p = first;

    while (p != null) {
      if (p.data.equals(element)) {
        return i;
      }
      p = p.next;
      i++;
    }
    return -1;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    ListNode p = first;
    while (p != null) {
      sb.append(p.data);
      if (p.next != null)
        sb.append(",");
      p = p.next;
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object next() {
    return null;
  }
}
