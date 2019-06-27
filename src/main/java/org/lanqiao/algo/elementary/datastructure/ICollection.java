package org.lanqiao.algo.elementary.datastructure;

/**
 * 定义动态集合上的基本操作
 * @author zhengwei lastmodified 2017年3月16日
 *
 */
public interface ICollection {
	/**
	 * 根据关键字搜索出对应对象
	 * 
	 * @param key
	 * @return
	 */
	Object search(Object key);

	/**
	 * 元素个数
	 * 
	 * @return
	 */
	int size();

	/**
	 * 集合是否为空
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 集合是否包含某个关键字元素
	 * 
	 * @param key
	 * @return
	 */
	boolean contains(Object key);

	/**
	 * 在集合中新增一个元素
	 * 
	 * @param e
	 * @return
	 */
	void add(Object e);

	/**
	 * 按关键字移除元素
	 * 
	 * @param key
	 * @return
	 */
	void remove(Object key);
}
