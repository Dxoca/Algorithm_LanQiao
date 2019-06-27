package org.lanqiao.algo.elementary.datastructure;

public class BTree {
	private Node			root;
	private int				size		= 0;
	private final int	DEGREE	= 5;

	public void insert(Object key) {
		if (root == null) {
			root = new Node();
			root.addKey(key);
		} else {
			insert(getLeaf(root, key), key);
		}
	}

	/**
	 * 获取应该插入key的叶子节点
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private Node getLeaf(Node peek, Object key) {
		if (peek.kids.size() == 0) { // 没有后代元素
			return peek;
		} else { // 有后代，后代个数至少为2，且后代的个数一定是数据个数+1
			IList keys = peek.keys;
			int p = keys.size();
			int i = p - 1;
			while (i >= 0 && compare(keys.get(i), key) > 0) {
				i--;
			}
			int index = i + 1;
			return getLeaf((Node) peek.kids.get(index),key);
		}
	}

	/**
	 * 插入，往叶子节点插入关键字；
	 * 
	 * @param leaf
	 * @param key
	 */
	private void insert(Node leaf, Object key) {
		leaf.addKey(key);
		// 分裂
		if (leaf.count == DEGREE) {
			divideLeaf(leaf);
			if(leaf.parent!=null){
				merge(leaf.parent,leaf);
			}
		}
	}

	/**
	 * 合并节点
	 * @param parent
	 * @param leaf
	 */
	private void merge(Node parent, Node leaf) {
		IList keys = parent.keys;
		int p = keys.size();
		int i = p - 1;
		Object e = leaf.keys.delete(0); // 并合并节点的唯一数据
		while (i >= 0 && compare(keys.get(i), e) > 0) {
			i--;
		}
		int index = i + 1;
		// 执行合并
		// TODO 合并节点要考虑不能给父节点增加两个子节点，只能增加一个，所以
		// 插入到头部，则合并儿子1，插入尾部，则合并
		keys.add( e, index);
		Node c1 = (Node) leaf.kids.delete(0);
		parent.kids.add(c1, index);
		c1.parent = parent;
		c1 = (Node) leaf.kids.delete(0);
		parent.kids.add(c1, index+1);
		c1.parent = parent;
		
		// TODO 合并后超过度数了怎么办
		// 1.分裂
	}

	/**
	 * 分裂叶子节点
	 * @param peek
	 */
	private void divideLeaf(Node peek) {
		Node k1 = new Node();
		k1.addKey(peek.removeKey(0));
		k1.addKey(peek.removeKey(0));
		
		Node k2 = new Node();
		k2.addKey(peek.removeKey(1));
		k2.addKey(peek.removeKey(1));

		peek.addKid(k1);
		k1.parent=peek;
		peek.addKid(k2);
		k2.parent=peek;
	}

	class Node {
		public Node parent=null;
		int		count;										// 关键字个数
		IList	keys	= new LinkedList();	// 数据,最多m-1个
		IList	kids	= new LinkedList();	// 子节点，最多m个


		void addKey(Object key) {
			int p = keys.size();
			if (p == 0) {
				keys.add(key);
			} else {
				int i = p - 1;
				while (i >= 0 && compare(keys.get(i), key) > 0) {
					i--;
				}
				int index = i + 1;
				keys.add(key, index);
			}
			count++;
		}

		public void addKid(Node kid) {
			kids.add(kid);
		}

		public Object removeKey(int i) {
			return keys.delete(i);
		}
	}

	private int compare(Object object, Object key) {
		Comparable o1 = (Comparable) object;
		Comparable o2 = (Comparable) key;
		return o1.compareTo(o2);
	}
}
