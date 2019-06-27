package org.lanqiao.algo.elementary._11_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.max;

public class MyTree<E> implements ITree<E> {
  private int size = 0;
  private TreeNode root;

  public MyTree(TreeNode root) {
    this.root = root;
    size++;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public TreeNode<E> getRoot() {
    return root;
  }

  @Override
  public TreeNode<E> getParent(TreeNode<E> x) {
    return x.parent;
  }

  @Override
  public TreeNode<E> getFirstChild(TreeNode<E> x) {
    return x.children.get(0);
  }

  @Override
  public TreeNode<E> getNextSibling(TreeNode<E> x) {
    List<TreeNode<E>> children = x.parent.children;
    int i = children.indexOf(x);
    // try {
    //   return children.get(i + 1);
    // } catch (Exception e) {
    //   return null;
    // }
    if (i == children.size() - 1) {
      return null;
    } else {
      return children.get(i + 1);
    }
  }

  public int getHeight() {
    return getHeight(root);
  }

  @Override
  public int getHeight(TreeNode<E> x) {
    if (x.children == null) {
      return 0;
    } else {
      int h = 0;
      for (int i = 0; i < x.children.size(); i++) {
        h = max(h, getHeight(x.children.get(i)));
      }
      return h + 1;
    }
  }

  @Override
  public void insertChild(TreeNode<E> p, TreeNode<E> child) {
    if (p.children == null) {
      p.children = new ArrayList<>();
    }
    p.children.add(child);
    child.parent = p;
    size++;
  }

  @Override
  public void deleteChild(TreeNode<E> p, int i) {
    p.children.remove(i);
    size--;
  }

  @Override
  public List<TreeNode<E>> preOrder(TreeNode<E> x) {
    return null;
  }

  @Override
  public List<TreeNode<E>> postOrder(TreeNode<E> x) {
    return null;
  }

  @Override
  public List<List<TreeNode<E>>> levelOrder(TreeNode<E> x) {
    List<List<TreeNode<E>>> res = new ArrayList<>();//list的list
    Queue<TreeNode<E>> q = new LinkedList<>();
    q.add(x);//初始化
    TreeNode<E> last = x;//标记上一行的最末节点
    TreeNode<E> nLast = null;//标记最新加入队列的节点
    List<TreeNode<E>> l = new ArrayList<>();//第一行的list
    res.add(l);

    while (!q.isEmpty()) {
      TreeNode<E> peek = q.peek();
      //把即将弹出的节点的子节点加入队列
      if (peek.children != null) {
        for (TreeNode<E> n : peek.children) {
          q.add(n);
          nLast = n;
        }
      }
      l.add(q.poll());//弹出,加入到当前层列表

      if (peek == last && !q.isEmpty()) {//如果现在弹出的节点是之前标记的最后节点，就要换列表
        l = new ArrayList<>();
        res.add(l);
        last = nLast;
      }
    }
    return res;
  }


  @Override
  public List<List<TreeNode<E>>> levelOrder() {
    return levelOrder(root);
  }
}
