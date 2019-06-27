package org.lanqiao.algo.util;

import org.assertj.core.util.Preconditions;
import org.lanqiao.algo.elementary._02searchAndSort._3InsertionSort;

import java.util.Arrays;
import java.util.Random;

public class Util {
  /**
   * 获取绝对的中值数，O(N)的样子
   */
  public static int getMedian(int[] arr, int p, int r) {
    if (arr.length == 1)
      return arr[p];
    int size = r - p + 1;// 数组长度
    //每五个元素一组
    int groupSize = (size % 5 == 0) ? (size / 5) : (size / 5 + 1);
    //存储各小组的中值
    int medians[] = new int[groupSize];
    int indexOfMedians = 0;
    //对每一组进行插入排序
    for (int j = 0; j < groupSize; j++) {
      //单独处理最后一组，因为最后一组可能不满5个元素
      if (j == groupSize - 1) {
        _3InsertionSort.sort(arr, p + j * 5, r); // 排序最后一组
        medians[indexOfMedians++] = arr[(p + j * 5 + r) / 2]; // 最后一组的中间那个
      } else {
        _3InsertionSort.sort(arr, p + j * 5, p + j * 5 + 4);  // 排序非最后一组的某个组
        medians[indexOfMedians++] = arr[p + j * 5 + 2];  // 当前组（排序后）的中间那个
      }
    }

    return getMedian(medians, 0, medians.length - 1);
  }

  /**
   * 获取指定范围指定个数的随机数组成的数组
   *
   * @param length
   * @param min
   * @param max
   * @return
   */
  public static int[] getRandomArr(int length, int min, int max) {
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = (int) (Math.random() * (max + 1 - min) + min);
    }
    return arr;
  }

  /**
   * 生成两个字符a,b之间的随机字符，结果包含a和b
   * @parameter a 范围较小的边界
   * @parameter b 范围较大的边界
   * @return a~b之间的一个随机字符，包含a,b
   */
  public static char getRandomChar(char a, char b) {
    if (a < b) {
      return (char) (a + (int) (Math.random() * (b - a + 1)));
    } else {
      return (char) (a + (int) (Math.random() * (a - b + 1)));
    }
  }

  /**生成一个小写字母的字符[a,z]*/
  public static char getRandomLowerCaseChar() {
    return getRandomChar('a', 'z');
  }

  /**生成一个随机小写字母串*/
  public static String getRandomLowerCaseString(int lenth) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < lenth; i++) {
      sb.append(getRandomLowerCaseChar());
    }
    return sb.toString();
  }

  /**生成一个随机小写字母串*/
  public static String getRandomLowerCaseStringWithOutRepeation(int lenth) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < lenth; i++) {
      char c = getRandomLowerCaseChar();
      if (sb.indexOf(c + "") == -1)
        sb.append(c);
      else
        --i;
    }
    return sb.toString();
  }

  public static String[] getRandomLowerCaseStrArr(int length, int strLen) {
    String[] arr = new String[length];
    for (int i = 0; i < length; i++) {
      arr[i] = getRandomLowerCaseString(new Random().nextInt(strLen) + 1);
    }
    return arr;
  }

  public static int[] getRandomArrWithoutRepetition(int length, int min, int max) {
    int[] arr = new int[length];
    int i = 0;
    while (i < length) {
      int tmp = (int) (new Random().nextDouble() * (max + 1 - min) + min);
      if (indexOf(arr, tmp) == -1) {
        arr[i] = tmp;
        i++;
      }
    }
    return arr;
  }

  /**
   * 在数组内原址交换元素
   *
   * @param arr
   * @param i
   * @param j
   */
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void swap(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * 求元素下标
   *
   * @param arr
   * @param e
   * @return
   */
  public static int indexOf(int[] arr, int e) {
    Preconditions.checkNotNull(arr);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == e) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 分区算法2：双向扫描
   */
  public static int partition2(int[] arr, int p, int r) {
    int pivot = arr[p];
    /*注意先右后左*/
    while (p < r) {
      while (p < r && arr[r] >= pivot)
        r--; // 从右侧寻找更小的
      arr[p] = arr[r]; // 小的往左侧调
      while (p < r && arr[p] <= pivot)
        p++; // 从左侧寻找更大的
      arr[r] = arr[p]; // 大的往右侧调
    }
    arr[p] = pivot;
    //System.out.println( "..." + p + "..." + Arrays.toString( arr ) );
    return p;
  }

  /**
   * 三区间划分法，应对元素有重复的情况
   *
   * @param arr
   * @param p
   * @param r
   * @return {位置a，其左侧一定小于主元；位置b，其右侧一定大于主元}
   */
  public static int[] partition3(int[] arr, int p, int r, int pivot) {
    int next_less_pos = p;// 指向等于主元的第一个元素，“等于”区间的头指针，其实也是“小于”区间的末指针的下一个指针
    int next_bigger_pos = r;// 指向未知的最后一个元素，其后是确认大于主元的区间，“未知”区间的末指针
    int next_scan_pos = p; // 从第一个元素开始扫描
    while (next_scan_pos <= next_bigger_pos) {
      if (arr[next_scan_pos] < pivot) { // 扫描到的元素小于主元，将当前元素挪到“等于”区间的前面
        swap(arr, next_scan_pos, next_less_pos);
        next_less_pos++; // “等于”区间的头指针向后移
        next_scan_pos++; // 扫描指针后移
      } else if (arr[next_scan_pos] > pivot) { // 扫描到的元素大于主元，交换当前元素和“未知”区间的末指针
        swap(arr, next_scan_pos, next_bigger_pos);
        next_bigger_pos--; // 未知区间末指针前移，这是扫描指针不能后移
      } else {
        next_scan_pos++; // 相等，“等于”区间加长了，但是“等于”区间的头指针和“未知”区间的末指针都不必移动
      }
    }
    return new int[]{next_less_pos, next_bigger_pos};
  }

  public static boolean isOdd(int i) {
    return (i & 1) == 1;
  }

  /**
   * 打印矩阵
   * @param matrix
   */
  public static void printMatrix(long[][] matrix) {
    for (long[] arr : matrix) {
      for (long e : arr) {
        System.out.print(e + "\t");
      }
      System.out.println();
    }
  }

  /**
   * 打印矩阵
   * @param matrix
   */
  public static void printMatrix(int[][] matrix) {
    for (int[] arr : matrix) {
      for (int e : arr) {
        System.out.print(e + "\t");
      }
      System.out.println();
    }
  }

  public static int ex(int a, int n) {
    if (n == 0) return 1;
    if (n == 1)
      return a;
    int temp = a; //a 的 1 次方
    int res = 1;
    int exponent = 1;
    while ((exponent << 1) < n) {
      temp = temp * temp;
      exponent = exponent << 1;
    }

    res *= ex(a, n - exponent);

    return res * temp;
  }
  /**
   * 求矩阵matrix的p次方
   * @param matrix
   * @param p
   * @return
   */
  public static long[][] matrixPower(long[][] matrix, long p) {
    //初始化结果为单位矩阵，对角线为1
    long[][] result = new long[matrix.length][matrix[0].length];
    //单位矩阵，相当于整数的1
    for (int i = 0; i < result.length; i++) {
      result[i][i] = 1;
    }

    //平方数
    long[][] pingFang = matrix; // 一次方
    while (p != 0) {
      if ((p & 1) != 0) { // 当前二进制位最低位为1，将当前平方数乘到结果中
        result = matrixMultiply(result, pingFang);//
      }
      //平方数继续上翻
      pingFang = matrixMultiply(pingFang, pingFang);
      p >>= 1;
    }
    return result;
  }

  /**
   *   矩阵乘法
   *   矩阵1为n*m矩阵，矩阵2为m*p矩阵
   *   结果为n*p矩阵
   */
  public static long[][] matrixMultiply(long[][] m1, long[][] m2) {
    final int n = m1.length;
    final int m = m1[0].length;
    if (m != m2.length) throw new IllegalArgumentException();
    final int p = m2[0].length;

    long[][] result = new long[n][p];// 新矩阵的行数为m1的行数，列数为m2的列数

    for (int i = 0; i < n; i++) {//m1的每一行
      for (int j = 0; j < p; j++) {//m2的每一列
        for (int k = 0; k < m; k++) {
          result[i][j] += m1[i][k] * m2[k][j];
        }
      }
    }
    return result;
  }

  public static String arrayToString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int e : arr) {
      sb.append(e);
    }
    return sb.toString();
  }

  public static int maxOf(int[] arr) {
    Preconditions.checkNotNull(arr);
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static void print(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }

  /**
   * 检查数组是否有序
   * @param arr 数组
   * @param isAsc 正序
   * @return
   */
  public static boolean checkOrdered(int[] arr, boolean isAsc) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1] && isAsc)
        return false;
      if (arr[i] < arr[i + 1] && !isAsc)
        return false;
    }
    return true;
  }

  /**
   * 获取数字src在d位上的数值，从个位开始计数
   * 个位：src/1 % 10
   * 十位：src/10 %10
   * 百位：src/100 %10
   *
   * @param src
   * @param d
   * @return
   */
  public static int getDigitOn(int src, int d) {
    return src / (int) (Math.pow(10, d - 1)) % 10;
  }

  /**
   * 在递增数组中，从左查找第一个比v大的元素的下标
   * @param dp
   * @param v
   * @param l
   * @param r
   * @return
   */
  public static int indexOfFirstBigger(int[] dp, int v, int l, int r) {
    while (l <= r) {
      int mid = (l + r) >> 1;
      if (dp[mid] > v) {
        r = mid;  //保留大于v的下标以防这是第一个
      } else {
        l = mid + 1;
      }
      if (l == r && dp[l] > v)
        return l;
    }
    return -1;
  }

  public static void duration(long x) {
    System.out.println(System.currentTimeMillis() - x + "ms");
  }


  public static void print(long[] hash_s) {
    for (int i = 0; i < hash_s.length; i++) {
      System.out.print(hash_s[i] + " ");
    }
    System.out.println();
  }
}