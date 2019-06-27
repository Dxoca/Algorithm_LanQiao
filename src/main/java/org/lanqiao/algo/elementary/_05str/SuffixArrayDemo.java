package org.lanqiao.algo.elementary._05str;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class SuffixArrayDemo {
  public static void main(String[] args) {
    // match();
    // String res = longestCommonSubString("abracadabra","ecadadabrbcrdar");
    // Assertions.assertThat(res).isEqualTo("adabr");
    int res = maxRepeatSubString2("1x23231923263");
    System.out.println(res);

  }

  /**
   * 不允许交叉
   * @param src
   * @return
   */
  public static int maxRepeatSubString2(String src) {
    Match03_SuffixArray.Suff[] sa = Match03_SuffixArray.getSa2(src);
    int[] height = Match03_SuffixArray.getHeight(src, sa);
    int l = 0;
    int r = height.length;
    int ans = 0;
    while (l <= r) {
      int mid = l + ((r - l) >> 1);//check的重叠长度
      if (check(height, sa, mid)) {
        if (mid == height.length / 2) {
          return mid;
        }
        l = mid + 1;
        ans = mid;
        // return mid;
      } else {
        r = mid - 1;
      }
    }
    return ans;
  }

  /**
   * 用len将height分组,小于组和大于等于组交替
   * 在大于组中更新最大最小原始小标,大转小的时候检查上一个大于组是否满足不重叠
   * 在小于组中,只需持续地将原始下标付给max和min,这样小转大的时候,可以保留小于组最后一个元素的下标
   * @param height
   * @param sa
   * @param len
   * @return
   */
  private static boolean check(int[] height, Match03_SuffixArray.Suff[] sa, int len) {
    int minIndex = sa[0].index;
    int maxIndex = sa[0].index;
    for (int i = 1; i < height.length; i++) {
      int index = sa[i].index;
      if (height[i] >= len) {//lcp大于len
        minIndex = min(minIndex, index);
        maxIndex = max(maxIndex, index);
      } else {
        if (maxIndex - minIndex >= len) {
          return true;
        }
        maxIndex = index;
        minIndex = index;
      }
    }
    /*   int tot = 0,maxsa=sa[0],minsa=sa[0];
    for (int i = 1; i < n; i++){
        if (height[i] >= k){
            maxsa = max(maxsa, sa[i]);
            minsa = min(minsa, sa[i]);
        }
        else{
            if (maxsa - minsa >= k){
                return true;
            }
            maxsa = sa[i], minsa = sa[i];
        }
    }
    if (maxsa - minsa >= k){
        return true;
    }
    return false;*/
    return (maxIndex - minIndex) >= len;
  }

  public static int maxRepeatSubString(String src) {
    Match03_SuffixArray.Suff[] sa = Match03_SuffixArray.getSa2(src);
    int[] height = Match03_SuffixArray.getHeight(src, sa);
    int maxHeight = 0;
    int maxIndex = -1;
    for (int i = 0; i < height.length; i++) {
      if (height[i] > maxHeight) {
        maxHeight = height[i];
        maxIndex = i;
      }
    }
    int index = sa[maxIndex].index;//转成原始下标
    System.out.println(src.substring(index, index + maxHeight));
    return maxHeight;
  }

  /**
   * 高度数组,是后缀数组中每两个字符串的最长公共前缀的长度
   * 用于求解两个串的最长公共子串:
   * 先拼起来,求后缀数组和高度数组
   * 高度数组的最大值指示了两个排序接近的后缀的公共前缀的长度
   * 两个字符串的最长公共子串一定就是这两条后缀的公共前缀
   */
  private static String longestCommonSubString(String s1, String s2) {
    String s = s1 + "$" + s2;
    Match03_SuffixArray.Suff[] sa = Match03_SuffixArray.getSa2(s);
    int[] height = Match03_SuffixArray.getHeight(s, sa);
    int maxHeight = 0;
    int index = -1;
    for (int i = 0; i < height.length; i++) {
      if (height[i] > maxHeight) {
        int index1 = sa[i].index;
        int index2 = sa[i - 1].index;
        if (Math.abs(index1 - index2) >= height[i]) {
          maxHeight = height[i];
          index = index1;
        }
      }

    }
    return s.substring(index, index + maxHeight);
  }

  private static void match() {
    String s = "ABABABABB";
    String p = "BABB";
    Match03_SuffixArray.Suff[] sa = Match03_SuffixArray.getSa2(s);//后缀数组
    int l = 0;
    int r = s.length() - 1;
    //二分查找,nlog(m)
    while (r >= l) {
      int mid = l + ((r - l) >> 1);
      //居中的后缀
      Match03_SuffixArray.Suff midSuff = sa[mid];
      String suffStr = s.substring(midSuff.index);
      int compareRes;
      //将后缀和模式串比较,O(n)
      if (suffStr.length() >= p.length())
        compareRes = suffStr.substring(0, p.length()).compareTo(p);
      else
        compareRes = suffStr.compareTo(p);
      //相等了,输出后缀的起始位置
      if (compareRes == 0) {
        System.out.println(midSuff.index);
        break;
      } else if (compareRes < 0) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
  }
}
