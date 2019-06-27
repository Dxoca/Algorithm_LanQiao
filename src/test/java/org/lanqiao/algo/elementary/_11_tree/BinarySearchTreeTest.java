package org.lanqiao.algo.elementary._11_tree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.lanqiao.algo.elementary._11_tree.BinarySearchTree;

import java.util.List;

public class BinarySearchTreeTest {
	IBinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();

	@Before
	public void init() {
		assertThat(tree.getHeight()).isEqualTo(0);
		tree.insert(4,"4");
		assertThat(tree.getHeight()).isEqualTo(1);
		tree.insert(1,null);
		assertThat(tree.getHeight()).isEqualTo(2);
		tree.insert(10,null);
		assertThat(tree.getHeight()).isEqualTo(2);
		tree.insert(14,null);
		assertThat(tree.getHeight()).isEqualTo(3);
    tree.insert(7, "heiheihei");
    assertThat(tree.getHeight()).isEqualTo(3);
		tree.insert(16,null);
		assertThat(tree.getHeight()).isEqualTo(4);
		tree.insert(9,null);
		assertThat(tree.getHeight()).isEqualTo(4);
		tree.insert(3,null);
		assertThat(tree.getHeight()).isEqualTo(4);
		tree.insert(5,null);
		assertThat(tree.getHeight()).isEqualTo(4);
		tree.insert(2,null);
		assertThat(tree.getHeight()).isEqualTo(4);
		tree.insert(20, null);
		tree.insert(25, null);
    assertThat(tree.getHeight()).isEqualTo(6);

    assertThat(tree.getSize()).isEqualTo(12);
  }

	@Test
	public void testLdr() {
		tree.inorder(k -> {
			System.out.println(k);

		});

	}

	@Test
	public void testLookup() {
		assertThat(tree.lookupValue(4)).isEqualTo("4");
    assertThat(tree.lookupValue(7)).isEqualTo("heiheihei");
  }

	@Test
	public void testMin() {
		assertThat(tree.min()).isEqualTo(1);
	}

	@Test
	public void testMax() {
    assertThat(tree.max()).isEqualTo(25);
  }

	@Test
	public void testRemove() {
		tree.remove(4);
		tree.inorder(obj -> {
			System.out.println(obj);

		});
		System.out.println("-------------------");
		tree.remove(9);
		tree.inorder(obj -> {
			System.out.println(obj);

		});
		System.out.println("-------------------");
		tree.remove(16);
		tree.inorder(obj -> {
			System.out.println(obj);

		});
	}

	@Test
	public void testSuccessor() {
		assertThat(tree.successor(3)).isEqualTo(4);
		assertThat(tree.predecessor(4)).isEqualTo(3);
		assertThat(tree.predecessor(1)).isNull();
	}

	@Test
	public void testGetHeight() {
    assertThat(tree.getHeight()).isEqualTo(6);
  }

	@Test
	public void isBalance() {
		assertThat(tree.isBalance()).isFalse();
	}

	@Test
	public void levelOrder() throws Exception {
    // List<List<BinarySearchTree<Integer,String>.BSTNode<Integer,String>>> lists = tree.levelOrder();
    // for (List<BinarySearchTree<Integer,String>.BSTNode<Integer,String>> l:
    // 		lists) {
    // 	for (BinarySearchTree<Integer,String>.BSTNode<Integer,String> node:l) {
    // 		System.out.print(node.key+"\t");
		// 	}
		// 	System.out.println("---");
		// }

		System.out.println(tree);
	}
}
