package org.lanqiao.algo.book.cc150;

import java.util.ArrayList;

/**
 * 编写一个方法，确定某字符串的所有排列组合。

 给定一个string A和一个int n,代表字符串和其长度，请返回所有该字符串字符的排列，
 保证字符串长度小于等于11且字符串中字符均为大写英文字符，

 */
public class _9_5全排列I {
  public static void main(String[] args) {
    ArrayList<String> res = new _9_5全排列I().getPermutation0("abcd");
    System.out.println(res.size());
    System.out.println(res);
  }

  /*逐步生成大法-迭代法*/
  public ArrayList<String> getPermutation0(String A) {
    int n = A.length();
    ArrayList<String> res = new ArrayList<>();
    res.add(A.charAt(0) + "");//初始化,包含第一个字符

    for (int i = 1; i < n; i++) {//第二个字符插入到前面生成集合的每个元素里面
      ArrayList<String> res_new = new ArrayList<>();
      char c = A.charAt(i);//新字符
      for (String str : res) {//访问上一趟集合中的每个字符串
        //  插入到每个位置,形成一个新串
        String newStr = c + str;//加在前面
        res_new.add(newStr);
        newStr = str + c;//加在后面
        res_new.add(newStr);
        //加在中间
        for (int j = 1; j < str.length(); j++) {
          newStr = str.substring(0, j) + c + str.substring(j);
          res_new.add(newStr);
        }
      }
      res = res_new;//更新

    }
    return res;
  }
}
