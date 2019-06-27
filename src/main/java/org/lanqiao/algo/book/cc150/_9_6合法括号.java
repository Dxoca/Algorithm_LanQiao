package org.lanqiao.algo.book.cc150;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.输出合法的括号组合
 * 输入括号对数
 * 输出所有合法组合
 * 输入:3
 * 输出:()()(),((())),(()()),()(()),(())(),
 * 2.判断一个字符串是否合法
 */

//(())(())
public class _9_6合法括号 {

  public static void main(String[] args) {
    _9_6合法括号 obj = new _9_6合法括号();
    Set<String> parenthesis = obj.parenthesis1(4);
    System.out.println(parenthesis.size());
    for (String s : parenthesis) {
      System.out.println(s);
    }
    // boolean b = obj.chkParenthesis("()a()()", 7);
    // System.out.println(b);
  }

  public boolean chkParenthesis(String A, int n) {
    if (n % 2 != 0)
      return false;
    int cnt = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '(') {
        cnt++;
      } else if (A.charAt(i) == ')') {
        cnt--;
      } else return false;
      if (cnt < 0) return false;
    }
    return true;
  }

  /*逐步生成之递归解法*/
  public Set<String> parenthesis(int n) {
    Set<String> s_n = new HashSet<>();
    if (n == 1) {
      s_n.add("()");
      return s_n;
    }
    Set<String> s_n_1 = parenthesis(n - 1);
    for (String eOfN_1 : s_n_1) {
      s_n.add("()" + eOfN_1);//添左
      s_n.add(eOfN_1 + "()");//添右
      s_n.add("(" + eOfN_1 + ")");//添在外部
      //  更正：在内部也可以添加
      for (int i = 0; i < eOfN_1.length(); i++) {
        char c = eOfN_1.charAt(i);//每一个字符
        if (c == '(')//只要这个字符是左括号，我们就可以在其后插入一对括号
          s_n.add(eOfN_1.substring(0, i + 1) + "()" + eOfN_1.substring(i + 1));
      }
    }
    return s_n;
  }

  /*迭代形式*/
  public Set<String> parenthesis1(int n) {
    Set<String> res = new HashSet<>();//保存上次迭代的状态
    res.add("()");
    if (n == 1) {
      return res;
    }
    for (int i = 2; i <= n; i++) {
      Set<String> res_new = new HashSet<>();

      for (String e : res) {
        res_new.add(e + "()");
        res_new.add("()" + e);
        res_new.add("(" + e + ")");
        //  更正：在内部也可以添加
        // for (int j = 0; j < e.length(); j++) {
        //   char c = e.charAt(j);//每一个字符
        //   if (c=='(')//只要这个字符是左括号，我们就可以在其后插入一对括号
        //     res_new.add(e.substring(0,j+1)+"()"+e.substring(j+1));
        // }
      }
      res = res_new;
    }
    return res;
  }
}
