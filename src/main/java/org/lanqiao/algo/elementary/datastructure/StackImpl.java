package org.lanqiao.algo.elementary.datastructure;

public class StackImpl extends LinkedList implements IStack {

	@Override
	public void push(Object e) {
		super.add(e);
	}

	@Override
	public Object pop() {
		int index = super.size()-1;
		Object lastElement = get(index);
		super.delete(index);
		return lastElement;
	}

}
