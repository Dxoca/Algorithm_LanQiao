package org.lanqiao.algo.elementary._11_tree;

public class AVLTree<K, V> extends BinarySearchTree<K, V> implements IBinarySearchTree<K, V> {
  @Override
  public BSTNode<K, V> insert(K key, V value) {
    //先按bst的方式来插入，再调整
    BSTNode<K, V> nnode = super.insert(key, value);
    //向上找到第一个不平衡的祖先p
    BSTNode<K, V>[] pqs = firstUnbalance(nnode);
    if (null != pqs) {//不平衡
      // System.out.println(pqs[0].key);
      reBalance(pqs);
    }
    return nnode;
  }

  /*分pqs的形状，来调用左旋和右旋*/
  private void reBalance(BSTNode<K, V>[] pqs) {
    if (pqs == null) return;
    BSTNode p = pqs[0];//不平衡的那个祖先
    BSTNode q = pqs[1];//p的子节点
    BSTNode s = pqs[2];//q的子节点

    if (q.isRight() && s.isRight()) {//右右型，以p为中心逆时针旋转
      leftRotate(p, q);
      // reBalance(firstUnbalance(q));
    } else if (q.isLeft() && s.isLeft()) {//左左型，以p为中心顺时针旋转
      rightRotate(p, q);
      // reBalance(firstUnbalance(q));
    } else if (q.isLeft() && s.isRight()) {//左右型
      // q.right = s.left;
      // if (s.left != null) {
      //   s.left.parent = q;
      //   s.left.isLeftChild = false;
      // }
      // q.parent = s;
      // s.left = q;
      // q.isLeftChild = true;
      //
      // s.parent = p;
      // p.left = s;
      // s.isLeftChild = true;
      leftRotate(q, s);//q，s左旋，变为左左型
      rightRotate(p, s);
      // reBalance(firstUnbalance(s));
    } else {//右左型
      // q.left = s.right;
      // if (s.right != null) {
      //   s.right.parent = q;
      //   s.right.isLeftChild = true;
      // }
      // q.parent = s;
      // s.right = q;
      // q.isLeftChild = false;
      //
      // s.parent = p;
      // p.right = s;
      // s.isLeftChild = false;
      rightRotate(q, s);
      leftRotate(p, s);
      // reBalance(firstUnbalance(s));
    }
  }

  private BSTNode<K, V>[] firstUnbalance(BSTNode<K, V> n) {
    if (n == null) return null;
    BSTNode s = n;
    BSTNode p = n.parent;
    if (p == null) return null;
    BSTNode g = p.parent;
    if (g == null) return null;
    if (unBalance(g)) {//不平衡了
      return new BSTNode[]{g, p, s};
    } else {
      return firstUnbalance(p);
    }

  }

  @Override
  public void remove(K key) {
    BSTNode<K, V> node = super.lookupNode(key);
    if (node == null) return;

    BSTNode<K, V> parent = node.parent;
    BSTNode<K, V> left = node.left;
    BSTNode<K, V> right = node.right;

    if (left == null && right == null) {//leaf node
      super.removeNode(node);
      reBalance(parent);
    } else if (right == null) {//has only left child.左孩子替换自身
      // if (node.isLeft()) {
      //   parent.left = left;
      //   left.parent = parent;
      // } else {
      //   if (parent == null) {// node is root
      //     left.parent = null;
      //     root = left;
      //   } else {
      //     parent.right = left;
      //     left.isLeftChild = false;
      //     left.parent = parent;
      //   }
      // }
      BSTNode<K, V> predecessor = maxNode(left);
      BSTNode<K, V> parentOfPredecessor = predecessor.parent;
      super.removeNode(predecessor);
      node.key = predecessor.key;
      node.value = predecessor.value;
      reBalance(parentOfPredecessor);

    } else {//有右孩子,找到右子树的最小
      BSTNode<K, V> successor = minNode(right);
      BSTNode<K, V> parentOfSuccessor = successor.parent;
      //  minNode must be leaf node
      super.removeNode(successor);
      node.key = successor.key;
      reBalance(parentOfSuccessor);
    }
  }

  private void reBalance(BSTNode<K, V> node) {
    if (node == null) return;

    BSTNode<K, V> right = node.right;
    BSTNode<K, V> left = node.left;
    int hOfRight = getHeight(right);
    int hOfleft = getHeight(left);

    if (hOfRight - hOfleft >= 2) {//右侧高
      leftRotate(node, right);//左旋
      reBalance(right);
    } else if (hOfRight - hOfleft <= -2) {
      rightRotate(node, left);
      reBalance(left);
    } else {
      reBalance(node.parent);
    }
  }
}
