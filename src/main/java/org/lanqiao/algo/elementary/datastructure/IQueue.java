package org.lanqiao.algo.elementary.datastructure;
/**
 * 描述队列的基本操作
 * @author zhengwei lastmodified 2017年3月16日
 *
 */
public interface IQueue extends IList {
	void enqueue(Object e);
	Object dequeue();
}
