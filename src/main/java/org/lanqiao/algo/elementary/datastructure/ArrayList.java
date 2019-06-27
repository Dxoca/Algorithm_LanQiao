package org.lanqiao.algo.elementary.datastructure;

/**
 * 
 * @author zhengwei
 *
 */
public class ArrayList implements IList {
	// 使用对象数组作为数据的实际持有者
	private Object[] data;
	private int size = 0;

	public ArrayList() {
		data = new Object[20];
	}

	public ArrayList(int capacity) {
		data = new Object[capacity];
	}

	/**
	 * 遍历搜索
	 */
	@Override
	public Object search(Object key) {

		for (int i = 0; i < data.length; i++) {
			if (key.equals(data[i]))
				return data[i];
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
	public boolean contains(Object key) {
		return search(key) != null;
	}

	@Override
	public void add(Object e) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				data[i] = e;
				size++;
				return;
			}
		}
	}

	@Override
	public void remove(Object key) {
		for (int i = 0; i < data.length; i++) {
			if (key.equals(data[i])) {
				data[i] = null;
				size--;
			}
		}
	}

	@Override
	public int indexOf(Object key) {
		for (int i = 0; i < data.length; i++) {
			if (key.equals(data[i]))
				return i;
		}
		return -1;
	}

	@Override
	public void add(Object e, int index) {
		if (data[index] == null) {
			data[index] = e;
		} else {// 如果指定下标处已经存在元素，怎么办？已经存在的元素是不能删除的
			Object tmp = data[index];
			data[index] = e;
			// 在这里我们假设数组没有存满
//			将原元素放在数组中第一个null位置，如果没有这个元素将被丢弃
			for (int i = 0; i < data.length; i++) {
				if(data[i]==null){
					data[i]=tmp;
					return;
				}
			}
		}
	}

	@Override
	public Object delete(int index) {
		
		data[index] = null;
		size--;
		return null;
	}

	@Override
	public Object get(int index) {
		return data[index];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < data.length; i++) {
			if (null != data[i])
				sb.append(data[i]).append(",");
		}
		sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
		return sb.toString();
	}

}
