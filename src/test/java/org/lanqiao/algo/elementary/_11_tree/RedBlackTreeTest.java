package org.lanqiao.algo.elementary._11_tree;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.lanqiao.algo.elementary._11_tree.RedBlackTree;

public class RedBlackTreeTest {
  RedBlackTree<Integer, String> tree = new RedBlackTree<>();

  @Before
	public void testInsert() {
    tree.insert(11, null);
    tree.insert(7, null);
    tree.insert(14, null);
    System.out.println(tree);
    System.out.println("=================");
    tree.insert(2, null);
    tree.insert(8, null);
    tree.insert(15, null);
    tree.insert(16, null);
    tree.insert(17, null);
    tree.insert(18, null);
    tree.insert(13, null);

	}

	@Test
	public void testInorder() {
		tree.inorder(obj->{
			System.out.println(obj);
		});
	}
	
	@Test
  public void testTreeIsOk() {
    System.out.println(tree);
	}

	@Test
	public void testRemove(){
		System.out.println(tree);
		tree.remove(7);
		System.out.println(tree);
    tree.remove(14);
    System.out.println(tree);
    tree.remove(11);
    System.out.println(tree);

	}
}
