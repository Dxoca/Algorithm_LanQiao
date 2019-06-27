package org.lanqiao.algo.elementary.datastructure;

/**
 * 在这个版本中，我们考虑得更加全面，充分考虑元素的紧密排列和扩容问题
 * 
 * @author zhengwei
 *
 */
public class ArrayList2 implements IList {
	// 使用对象数组作为数据的实际持有者
	private Object[] data;
	private int size = 0;// 实际元素个数
	private final int DELTA; // 扩容的增量

	public ArrayList2() {
		data = new Object[20];
		DELTA = 20;
	}

	public ArrayList2(int capacity) {
		data = new Object[capacity];
		DELTA = capacity;
	}

	/**
	 * 遍历搜索
	 */
	@Override
	public Object search(Object key) {

		for (int i = 0; i < data.length; i++) {
			if ((data[i] == null && key == null) || (key.equals(data[i])))
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
		// 如果元素个数等于数组现在的长度，那说明现在的集合已经存满了，我们必须要扩容
		if (size == data.length) {
			Object[] data2 = new Object[size + DELTA];
			// COPY
			for (int i = 0; i < data.length; i++) {
				data2[i] = data[i];
			}
			// switch
			data = data2;
		}
		data[size] = e;
		size++;
	}

	@Override
	public void remove(Object key) {
		for (int i = 0; i < data.length; i++) {
			if ((data[i] == null && key == null) || (key.equals(data[i]))) {
				data[i] = null;
				// 后继元素前移
				for (int j = i; j < size - 1; j++) {
					data[j] = data[j + 1];
				}
				size--;
				return;
			}
		}
	}

	@Override
	public int indexOf(Object key) {
		for (int i = 0; i < data.length; i++) {
			if ((data[i] == null && key == null) || (key.equals(data[i])))
				return i;
		}
		return -1;
	}

	@Override
	public void add(Object e, int index) {
		// 如果元素个数等于数组现在的长度，那说明现在的集合已经存满了，我们必须要扩容
		if (size == data.length) {
			Object[] data2 = new Object[size + DELTA];
			// COPY
			for (int i = 0; i < data.length; i++) {
				data2[i] = data[i];
			}
			// switch
			data = data2;
		}
		// 如果索引超出当前大小
		if (index >= size) {
			add(e);
			size++;
			return;
		}
		for (int j = size; j > index; j--) {
			data[j] = data[j - 1];
		}
		data[index] = e;
		size++;
	}

	@Override
	public Object delete(int index) {
		if (index >= size)
			return null;
		Object v = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return v;
	}

	@Override
	public Object get(int index) {
		return data[index];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			sb.append(data[i]).append(",");
		}
		sb.deleteCharAt(sb.lastIndexOf(",")).append("]");
		return sb.toString();
	}

}
