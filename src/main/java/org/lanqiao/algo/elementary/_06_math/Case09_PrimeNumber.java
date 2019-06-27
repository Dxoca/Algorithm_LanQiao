package org.lanqiao.algo.elementary._06_math;

import java.util.HashMap;
import java.util.Map;

public class Case09_PrimeNumber {
  public static void main(String[] args) {
    boolean res = isPrime(7L);
    System.out.println(res);
    Map<Integer, Integer> map = primeFactor(100);
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int k = entry.getKey();
      int v = entry.getValue();
      for (int i = 0; i < v; i++) {
        sb.append("*" + k);
      }
    }
    System.out.println(sb.substring(1));
    System.out.println(map);
  }

  /**
   * 测试num是否素数
   * @param num
   * @return
   */
  public static boolean isPrime(long num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
  }

  /**
   * 质因数分解 8 2*2*2
   * @param num
   * @return
   */
  public static Map<Integer, Integer> primeFactor(int num) {
    Map<Integer, Integer> map = new HashMap<>();//质因数-出现次数
    for (int i = 2; i * i <= num; i++) {
      while (num % i == 0) {
        Integer v = map.get(i);
        if (v == null)
          map.put(i, 1);
        else
          map.put(i, v + 1);
        num /= i;
      }
    }
    return map;
  }
}
