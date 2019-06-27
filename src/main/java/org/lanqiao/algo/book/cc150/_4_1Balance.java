package org.lanqiao.algo.book.cc150;


import org.assertj.core.api.Assertions;
import org.lanqiao.algo.TreeNode;
import org.lanqiao.algo.TreeUtil;

import java.util.HashMap;
import java.util.Map;



/**
 *

 实现一个函数，检查二叉树是否平衡，<br />
 平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。<br />

 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。<br />

 @author zhengwei
 */
public class _4_1Balance {
  public static void main(String[] args) {
    _4_1Balance obj = new _4_1Balance();
    TreeNode root = TreeUtil.buildTree(1, 2, 3);
    Assertions.assertThat( obj.isBalance( root ) ).isTrue();
    root.left.left = TreeUtil.buildTree(4, 5, 6);
    root.right.right = TreeUtil.buildTree(4, 5, 6);
    Assertions.assertThat( obj.isBalance( root ) ).isFalse();
  }


  public boolean isBalance(TreeNode root) {
    return isBalance( root, new HashMap<TreeNode, Integer>() );
  }

  public boolean isBalance(TreeNode root, Map<TreeNode, Integer> heightMap) {
    if (null == root || (root.left == null && root.right == null))
      return true;

    boolean b = Math.abs( heightOf( root.left, heightMap ) - heightOf( root.right, heightMap ) ) <= 1;
    return isBalance( root.left, heightMap )
        && isBalance( root.right, heightMap )
        && b;
  }

  private int heightOf(TreeNode node, Map<TreeNode, Integer> heightMap) {
    if (node == null)
      return 0;

    Integer height = heightMap.get( node );
    if (height != null) {
      return height;
    }

    if (node.left == null && node.right == null)
      heightMap.put( node, 1 );
    else if (node.left == null)
      heightMap.put( node, 1 + heightOf( node.right, heightMap ) );
    else if (node.right == null)
      heightMap.put( node, 1 + heightOf( node.left, heightMap ) );
    else
      heightMap.put(node, 1 + Math.max(heightOf(node.left, heightMap), heightOf(node.right, heightMap)));

    return heightMap.get( node );
  }
}