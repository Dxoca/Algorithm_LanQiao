package org.lanqiao.algo.book.cc150;

/**
 * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，
 * 在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
 测试样例：
 [[1,2,3],[4,5,6],[7,8,9]],3
 返回：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class _1_6Transform {
  /**

   思路：

   把矩阵想成一个洋葱，一圈包着一圈，外一圈每一条边比里一圈每一条边长度多2，
   外层循环一趟旋转一圈，因此只需n/2趟
   内层循环实际控制当前这圈的每个元素的旋转，边界是从i开始到倒数i结束

   * @param mat
   * @param n
   * @return
   */
  public int[][] transformImage(int[][] mat, int n) {
    if (mat==null)
      return null;
    for (int i = 0; i < n/2; i++) {  // 行号，层数
      for (int j = i; j < n-1-i; j++) { // 列号,层起点
        int temp = mat[i][j];
        mat[i][j] = mat[n-1-j][i];
        mat[n-1-j][i] = mat[n-1-i][n-1-j];
        mat[n-1-i][n-1-j] = mat[j][n-1-i];
        mat[j][n-1-i] = temp;
      }
    }
    return mat;
  }

  public static void main(String[] args) {
    int[][] mat = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    mat = new _1_6Transform().transformImage(mat,3);

    for (int[] a1:mat
         ) {
      for (int e:a1
           ) {
        System.out.print(e+"\t");
      }
      System.out.println();
    }
  }
}
