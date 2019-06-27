package org.lanqiao.algo.elementary._11_tree;


public class 树的恢复 {
  public static void main(String[] args) {
    int[] zhongXu = {3, 2, 1, 4, 5, 7, 6};
    int[] houXu = {3, 1, 2, 5, 6, 7, 4};
    TreeNode<Integer> node = f(zhongXu, houXu);
    // inOrder(node);
    // postOrder(node);
    solution(node, 0);
    System.out.println(min);
    System.out.println(min_node);
  }

  static int min = Integer.MAX_VALUE;
  static int min_node = Integer.MAX_VALUE;
  ;

  /**
   *
   * @param node
   * @param val 路径上已经累计求和
   */
  private static void solution(TreeNode<Integer> node, int val) {
    if (node.left == null && node.right == null) {
      int x = val + node.val; // 总和
      if (x < min || (x == min && node.val < min_node)) {//如果累计求和是历史最小
        min = x;
        min_node = node.val;//叶子节点的值
      }
    }
    if (node.left != null)
      solution(node.left, val + node.val);
    if (node.right != null)
      solution(node.right, val + node.val);
  }

  //中序遍历
  private static void inOrder(TreeNode root) {
    if (root == null)
      return;
    inOrder(root.left);
    System.out.println(root.val);
    inOrder(root.right);

  }

  /**
   * 后序遍历
   * */
  private static void postOrder(TreeNode n1) {
    if (n1 == null)
      return;
    postOrder(n1.left);
    postOrder(n1.right);
    System.out.println(n1.val);
  }

  private static TreeNode<Integer> f(int[] zhongXu, int[] houXu) {

    int l1 = zhongXu.length;
    if (l1 == 1)
      return new TreeNode<>(zhongXu[0]);
    //1.找到根
    int root_value = houXu[l1 - 1];
    //  2.用根到中序里面去定位，划分中左右子树
    int indexInZhongxu = -1;
    for (int i = 0; i < l1; i++) {
      if (zhongXu[i] == root_value) {
        indexInZhongxu = i;
        break;
      }
    }
    TreeNode<Integer> root = new TreeNode(root_value);

    int[] newZhongXu_zuo = new int[indexInZhongxu];
    int[] newHouXu_zuo = new int[indexInZhongxu];
    int[] newZhongXu_you = new int[l1 - indexInZhongxu - 1];
    int[] newHouXu_you = new int[l1 - indexInZhongxu - 1];
    //复制左子树
    for (int i = 0; i < newHouXu_zuo.length; i++) {
      newZhongXu_zuo[i] = zhongXu[i];
      newHouXu_zuo[i] = houXu[i];
    }
    //复制右子树
    for (int i = 0; i < newZhongXu_you.length; i++) {
      newZhongXu_you[i] = zhongXu[indexInZhongxu + i + 1];
      newHouXu_you[i] = houXu[indexInZhongxu + i];
    }

    root.left = f(newZhongXu_zuo, newHouXu_zuo);
    root.right = f(newZhongXu_you, newHouXu_you);
    return root;
  }

  static class TreeNode<T> {

    public T val;
    public TreeNode<Integer> left = null;
    public TreeNode<T> right = null;

    public TreeNode(T val) {
      this.val = val;
    }

  }
}
