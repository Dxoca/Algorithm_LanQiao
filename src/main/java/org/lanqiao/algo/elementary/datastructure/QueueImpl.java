package org.lanqiao.algo.elementary.datastructure;

public class QueueImpl extends LinkedList implements IQueue {

	@Override
	public void enqueue(Object e) {
		super.add(e);
	}

	@Override
	public Object dequeue() {
		Object firstElement = super.get(0);
		super.delete(0);
		return firstElement;
	}

}
