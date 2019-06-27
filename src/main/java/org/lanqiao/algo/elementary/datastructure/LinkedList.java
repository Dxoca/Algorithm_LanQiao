package org.lanqiao.algo.elementary.datastructure;

import org.assertj.core.util.Preconditions;

/**
 * 双向链表
 */
public class LinkedList implements IList {

  private Entry head;
  private Entry last;
  private int size = 0;// 元素个数

  @Override
  public void add(Object obj) {
    // 加第一个元素
    if (size == 0) {
      head = new Entry(obj, null, null);
      last = head;
    } else {
      Entry temp = new Entry(obj, last, null);
      last.next = temp;
      last = temp;
    }
    size++;
  }

  @Override
  public void add(Object obj, int index) {
    Preconditions.checkArgument(index >= 0 && index <= size, "请检查index范围，应该在%d,%d之间", 0, size);
    if (index == size) {
      add(obj);
    } else {
      Entry e = getEntry(index);
      Entry temp = new Entry(obj, null, null);
      if (e == head) {
        head.pre = temp;
        temp.next = head;
        head = temp;
      } else {
        // 交换指针
        e.pre.next = temp;
        temp.next = e;
        temp.pre = e.pre;
        e.pre = temp;
      }
      size++;
    }

  }

  @Override
  public Object delete(int index) {
    Preconditions.checkArgument(index >= 0 && index <= size, "请检查index范围，应该在%d,%d之间", 0, size);
    Entry e = getEntry(index);
    Object v = e.value;
    removeEntry(e);
    return v;
  }

  @Override
  public void remove(Object key) {
    Entry tmp = getEntry(key);
    removeEntry(tmp);
  }

  private void removeEntry(Entry e) {
    if (null == e) {
      return;
    }
    if (head == e) {
      if (head.next != null) {
        head.next.pre = null;
      } else { // 只有一个元素
        last = null;
      }
      head = head.next;
      size--;
      return;
    }

    // 考虑最后一个元素
    if (last == e) {
      if (e.pre != null) {
        e.pre.next = null;
      }
      last = e.pre;
      size--;
      return;
    }

    e.pre.next = e.next;
    e.next.pre = e.pre;
    size--;
  }

  @Override
  public Object get(int index) {
    if (index >= size || index < 0)
      return null;
    return getEntry(index).value;
  }

  @Override
  public Object search(Object key) {
    Entry tmp = getEntry(key);
    if (null == tmp)
      return null;
    else
      return tmp.value;
  }

  @Override
  public boolean contains(Object key) {
    return search(key) != null;
  }

  /**
   * 得到第i个与元素
   *
   * @param index
   * @return
   */
  private Entry getEntry(int index) {
    // 找到i指向的那个元素
    Entry e = head;
    int j = 0;
    while (j < index) {
      e = e.next;
      j++;
    }
    return e;
  }

  private Entry getEntry(Object key) {
    Entry tmp = head;
    while (tmp != null) {
      if ((tmp.value == null && key == null) || tmp.value.equals(key)) {
        return tmp;
      } else {
        tmp = tmp.next;
      }
    }
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int indexOf(Object e) {
    int index = 0;
    Entry tmp = head;
    while (tmp != null) {
      if ((tmp.value == null && e == null) || tmp.value.equals(e)) {// 命中
        return index;
      } else {
        tmp = tmp.next;
        index++;
      }
    }
    return -1;
  }

  class Entry {
    Object value;
    Entry pre;
    Entry next;

    public Entry(Object value, Entry pre, Entry next) {
      super();
      this.value = value;
      this.pre = pre;
      this.next = next;
    }

    @Override
    public String toString() {
      return value.toString();
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Entry other = (Entry) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false;
      return true;
    }

    private LinkedList getOuterType() {
      return LinkedList.this;
    }

  }

  @Override
  public String toString() {
    Entry e = head;
    StringBuilder sb = new StringBuilder("[");
    while (e != null) {
      sb.append(e.value.toString()).append(",");
      e = e.next;
    }

    final int index = sb.lastIndexOf(",");
    if (index == -1)
      sb.append("]");
    else
      sb.deleteCharAt(index).append("]");
    return sb.toString();
  }
}
