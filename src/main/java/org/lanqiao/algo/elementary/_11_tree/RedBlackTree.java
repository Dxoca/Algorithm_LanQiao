package org.lanqiao.algo.elementary._11_tree;

import java.util.List;

/**
 * 红黑树 <br/>
 * 1)每个节点要么是红色要么是黑色
 * 2)根节点是黑色的
 * 3)每个叶子节点(NIL)是黑色
 * 4)红色节点的的子节点都是黑色的
 * 5)对每个节点，从该节点到其后代叶子节点的简单路径上，均包含数目相同的黑色节点
 *
 * 通常我们认为树末梢的节点还有两个为空的节点，这些空节点是黑色的，所以不必检测第三条
 *
 * @author zhengwei
 *
 */
public class RedBlackTree<K, V> extends BinarySearchTree<K, V> {
  private static final boolean RED = true;
  private static final boolean BLACK = false;

  @Override
  public BSTNode<K, V> insert(K key, V value) {
    BSTNode<K, V> newNode = super.insert(key, value);
    fixAfterInsert2(newNode.parent, newNode);
    colorBlack(root);// 根节点染黑
    size++;
    return newNode;
  }


  /**
   * 保持树的平衡，这里采用模式匹配的写法：
   *            y
   *          x   z
   *        A  B C  D
   *
   * @param parent
   *          新增节点的父节点
   * @param newNode
   *          新增节点
   * @return
   */
  private void fixAfterInsert(BSTNode parent, BSTNode newNode) {
    if (parent == null) {
      root = newNode;
      return;
    }
    if (colorOf(parent) == RED && colorOf(newNode) == RED) {
      //虚位以待，把四种情况的ABC和xyz定好，然后统一处理
      BSTNode A = null, B = null, C = null,
          D = null, x = null, y = null, z = null;
      // case 1 左左
      /*
      *
                z
              y   D
            x  C
          A  B
      */
      if (parent.isLeftChild && newNode.isLeftChild) {
        x = newNode;
        A = x.left;
        B = x.right;

        y = parent;
        C = y.right;

        z = y.parent;
        D = z.right;

        changePeek(y, z);
      }
      // case 2 右右
      /*
      *
                x
              A   y
                B   z
                  C   D
       --> A x B y C z D
      */
      else if (!parent.isLeftChild && !newNode.isLeftChild) {
        z = newNode;
        C = z.left;
        D = z.right;

        y = z.parent;
        B = y.left;

        x = y.parent;
        A = x.left;

        changePeek(y, x);
      }
      // case 3 左右
      else if (parent.isLeftChild && !newNode.isLeftChild) {
        y = newNode;
        B = y.left;
        C = y.right;

        x = y.parent;
        A = x.left;

        z = x.parent;
        D = z.right;

        changePeek(y, z);
      }
      // case 4 右左
      else if (!parent.isLeftChild && newNode.isLeftChild) {
        y = newNode;
        B = y.left;
        C = y.right;

        z = y.parent;
        D = z.right;

        x = z.parent;
        A = x.left;

        changePeek(y, x);
      }
//------------------统一变为一种形式，换父子链接并染色----------------------
      x.parent = y;
      z.parent = y;
      y.left = x;
      y.right = z;
      x.left = A;
      if (A != null) {
        A.parent = x;
        A.isLeftChild = true;
      }
      x.right = B;
      if (B != null) {
        B.parent = x;
        B.isLeftChild = false;
      }
      z.left = C;
      z.right = D;
      if (C != null) {
        C.parent = z;
        C.isLeftChild = true;
      }
      if (D != null) {
        D.parent = z;
        D.isLeftChild = false;
      }
      x.isLeftChild = true;
      z.isLeftChild = false;
      colorBlack(x);
      colorBlack(z);
      colorRed(y);
//			递归向上追溯
      fixAfterInsert(y.parent, y);
    }

  }

  private void fixAfterInsert2(BSTNode parent, BSTNode newNode) {
    if (parent == null) {
      root = newNode;
      return;
    }
    if (colorOf(parent) == RED) {
      //uncle存在且为红色
      BSTNode grand = parent.parent;
      BSTNode uncle = parent.isLeftChild ? grand.right : grand.left;
      //uncle为红
      if (uncle != null && colorOf(uncle) == RED) {
        colorRed(grand);
        colorBlack(parent);
        colorBlack(uncle);
        fixAfterInsert2(grand.parent, grand);
      } else {//uncle为空=uncle为黑
        if (parent.isLeftChild && newNode.isLeftChild) {//左左型
          colorRed(grand);
          colorBlack(parent);
          rightRotate(grand, parent);
        } else if (parent.isLeftChild && !newNode.isLeftChild) {//左右型
          leftRotate(parent, newNode);
          colorRed(grand);
          colorBlack(newNode);
          rightRotate(grand, newNode);
        } else if (!parent.isLeftChild && !newNode.isLeftChild) {//右右型
          colorRed(grand);
          colorBlack(parent);
          leftRotate(grand, parent);
        } else {//右左型
          rightRotate(parent, newNode);
          colorRed(grand);
          colorBlack(newNode);
          leftRotate(grand, newNode);
        }
      }
    }
  }

  /**
   * 切换顶点，设施newPeek为新顶点
   *
   * @param newPeek
   *          新顶点
   * @param oldPeek
   *          旧顶点
   */
  private void changePeek(BSTNode newPeek, BSTNode oldPeek) {
    newPeek.parent = oldPeek.parent;
    newPeek.isLeftChild = oldPeek.isLeftChild;
    if (oldPeek.parent != null) {
      if (oldPeek.isLeftChild)
        oldPeek.parent.left = newPeek;
      else
        oldPeek.parent.right = newPeek;
    } else {
      root = newPeek;
    }
  }

  private void colorRed(BSTNode node) {
    if (null != node)
      node.isRed = true;
  }

  private void colorBlack(BSTNode node) {
    if (null != node)
      node.isRed = false;
  }

  /**
   * 红黑树删除及修复
   1、双支转单支
   2、删除D，并顶替N
   3、D为黑，需修复
   4、N为红，很简单（N变黑即可）
   N为黑，系列复杂的修复
   * @param key
   */
  @Override
  public void remove(K key) {
    BSTNode toDelete = lookupNode(key);
    if (toDelete == null)
      return;
    size--;

    // 如果是严格的内部节点，拷贝后继元素的内容到待删节点，然后toDelete指向后继，合并到后面一同处理
    if (toDelete.left != null && toDelete.right != null) {
      BSTNode s = successor(toDelete);// 后继右子树的最左端
      toDelete.key = s.key;
      toDelete = s;  // p指向其后继，是待删除的
    } // toDelete has 2 children

    //此时，toDelete一定是单支，或者是叶子
    // 用于顶替待删节点的
    BSTNode N = (toDelete.left != null ? toDelete.left : toDelete.right);
    //N是用来顶替toDelete的
    if (N != null) {
      //-------这一段是顶替操作-----------
      // Link N to parent
      N.parent = toDelete.parent;
      if (toDelete.parent == null) {
        root = N;
        colorBlack(N);
      } else if (toDelete.isLeft()) { // p是左孩子
        toDelete.parent.left = N;
        N.isLeftChild = true;
      } else {  // p是右孩子
        toDelete.parent.right = N;
        N.isLeftChild = false;
      }

      // Null out links so they are OK to use by fixAfterDeletion.
      toDelete.left = toDelete.right = toDelete.parent = null;
      //-------这一段是顶替操作  end-----------

      // toDelete为黑才需要修复
      if (colorOf(toDelete) == BLACK)
        fixAfterDeletion(N);
    } // toDelete has 1 children
    else if (toDelete.parent == null) { // toDelete是叶子：1.它是根—— if it is the only node.
      root = null;//变成空树
    } else { // toDelete是叶子：2.不是根，没有顶替者.
      // toDelete为黑才需要修复
      if (colorOf(toDelete) == BLACK)
        fixAfterDeletion(toDelete);// 先修复再cut掉

      //以下代码执行切掉叶子的动作
      if (toDelete.parent != null) {
        if (toDelete == toDelete.parent.left)
          toDelete.parent.left = null;
        else if (toDelete == toDelete.parent.right)
          toDelete.parent.right = null;
        toDelete.parent = null;
      }
    }

  }

  private void fixAfterDeletion(BSTNode N) {
    if (colorOf(N) == RED) {//N为红，简单变黑即可
      colorBlack(N);
    }
    //N为黑，即double black，删除节点和顶替节点都为黑，进行若干种情况的讨论
    // case1：N是新的根节点，且N为黑色，没有任何破坏
    else if (N.parent == null) {
    } else {//为黑，且不是根节点
      case2(N);
    }
  }

  /*-------情况2：兄弟为红色，转移为兄弟为黑-------*/
  private void case2(BSTNode N) {
    BSTNode parent = N.parent;
    BSTNode sib = sib(N, parent);
    if (colorOf(sib) == RED) {
      colorBlack(sib);
      colorRed(parent);
      if (N.isLeft())
        leftRotate(parent, N);
      else
        rightRotate(parent, N);
    }
    case3(N);//sib must be  black.
  }

  private BSTNode sib(BSTNode N, BSTNode parent) {
    BSTNode sib;
    if (N.isLeft()) {
      sib = parent.right;
    } else {
      sib = parent.left;
    }
    return sib;
  }

  /*-------情况3：兄弟为黑的前提下，讨论兄弟的双子为黑（兄弟可以被染红）
  * 1.父为红色，双子为黑或者不为黑都走向case4
  * 2.父为黑色，兄弟染红，递归父节点*/
  private void case3(BSTNode N) {
    BSTNode parent = N.parent;
    BSTNode sib = sib(N, parent);
    /* 2.父为黑色，兄弟染红，递归父节点*/
    if (colorOf(parent) == BLACK &&
        (sib.left == null || colorOf(sib.left) == BLACK) &&
        (sib.right == null || colorOf(sib.right) == BLACK)) {
      colorRed(sib);
      fixAfterDeletion(parent);
    } else {
      case4(N);
    }
  }

  /*-------情况4.1：P为红，兄弟为黑，且兄弟的双子为黑——父兄反色，即可
  * 4.2 P红或者黑，兄弟为黑，无论哪一子为红，都转移到case5*/
  private void case4(BSTNode N) {
    BSTNode parent = N.parent;
    BSTNode sib = sib(N, parent);
    if (colorOf(parent) == RED &&
        colorOf(sib.left) == BLACK &&
        colorOf(sib.right) == BLACK) {
      colorRed(sib);
      colorBlack(parent);//刚好平衡
    } else {
      case5(N);
    }
  }

  /*-------情况5，兄弟向内的孩子为红，通过旋转转移为case6：向外的孩子为红*/
  private void case5(BSTNode N) {
    BSTNode parent = N.parent;
    BSTNode sib = sib(N, parent);
    if (N.isLeft() && colorOf(sib.right) == BLACK) {
      // s->color = RED;
      // s->left->color = BLACK;
      // rotate_right(s);
      colorBlack(sib.left);
      colorRed(sib);
      rightRotate(sib, sib.left);//兄弟的外侧孩子变为红色
    } else if (N.isRight() && colorOf(sib.left) == BLACK) {
      colorRed(sib);
      colorBlack(sib.right);
      leftRotate(sib, sib.right);
    }
    case6(N);
  }

  /*-------情况6兄弟向外的孩子为红
  * 兄弟染为父节点的颜色
  * 父节点染黑
  * 父节点旋转*/
  private void case6(BSTNode N) {
    BSTNode parent = N.parent;
    BSTNode sib = sib(N, parent);
    setColor(sib, colorOf(parent));
    colorBlack(parent);
    if (N.isLeft()) {
      colorBlack(sib.right);
      leftRotate(parent, sib);
    } else {
      colorBlack(sib.left);
      rightRotate(parent, sib);
    }
  }

  private void setColor(BSTNode sib, boolean colorOf) {
    if (sib != null)
      sib.isRed = colorOf;
  }

  private BSTNode rightOf(BSTNode parent) {
    return parent.right;
  }

  private BSTNode leftOf(BSTNode parent) {
    return parent.left;
  }

  private boolean colorOf(BSTNode x) {
    if (x == null)
      return false;
    return x.isRed;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    List<List<BSTNode<K, V>>> lists = super.levelOrder();
    for (List<BSTNode<K, V>> l : lists) {
      for (BSTNode<K, V> n : l) {
        sb.append(n.toString() + "\t");
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
