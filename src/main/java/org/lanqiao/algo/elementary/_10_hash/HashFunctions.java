package org.lanqiao.algo.elementary._10_hash;

public class HashFunctions {
  /*取余法*/
  static int hash1(Object x, int prime) {
    return x.hashCode() % prime;
  }

  /*加法*/
  static int additiveHash(Object key, int prime) {
    String objStr = key.toString();
    int hash = objStr.length(), i = 0;
    //遍历每个字符
    for (; i < objStr.length(); i++)
      hash += objStr.charAt(i);
    return (hash % prime);
  }

  /*利用位运算*/
  static int rotatingHash(String key, int prime) {

    int hash = key.length(), i = 0;

    for (; i < key.length(); ++i)

      hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);

    return (hash % prime);

  }

  /*乘法*/
  static long bernstein(String key, int prime) {
    long h = 0;
    long seed = 31;//素数
    for (int i = 0; i != key.length(); ++i) {
      h = seed * h + key.charAt(i);
    }
    return h % prime;
  }
}
