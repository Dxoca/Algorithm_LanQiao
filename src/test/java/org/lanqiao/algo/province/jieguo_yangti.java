package org.lanqiao.algo.province;

public class jieguo_yangti {
  public static void main(String[] args) {
    for (int i = 100; i < 1000; i++) {
      if (String.valueOf(i * i).endsWith(i + ""))
        System.out.println(i + " " + (i * i));
    }
  }
}
