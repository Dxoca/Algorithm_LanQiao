package org.lanqiao.algo.elementary.digit;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.assertj.core.util.Preconditions;

/**
 * 数字1-9，中间可以插入+-或者空，不改变数字的顺序，要求最终计算结果为100
 * 如：123+45-67+8-9==100
 * 请输出这样的表达式
 */
public class To100 {
  public static void main(String[] args) {
    // 穷举所有的可能，每种可能形成一个表达式
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
              for (int n = 0; n < 3; n++) {
                for (int o = 0; o < 3; o++) {
                  for (int p = 0; p < 3; p++) {
                    String exepString = getExepression(i,j,k,l,m,n,o,p);
                    JexlEngine jexlEngine = new JexlBuilder().create();
                    JexlExpression jexlExpression = jexlEngine.createExpression(exepString);
                    Object evaluate = jexlExpression.evaluate(null);
                    if (evaluate.equals(100)) {
                      System.out.print(exepString);
                      System.out.println("==" + evaluate);
                    }
                  }
                }
              }
            }
          }
        }
      }  
    }
  }

  private static String getExepression(int i, int j, int k, int l, int m, int n, int o, int p) {
    return 1+toOperator(i)+2+toOperator(j)+3+toOperator(k)+4+toOperator(l)
        +5+toOperator(m)+6+toOperator(n)+7+toOperator(o)+8+toOperator(p)+9;
  }

  private static String toOperator(int i) {
    Preconditions.checkArgument(i<3&&i>=0,"参数应该大于等于0小于3");
    switch(i){
      case 0:
        return "";
      case 1:
        return "+";
      case 2:
        return "-";
    }
    return null;
  }
}
