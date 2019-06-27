package org.lanqiao.algo.province;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*枚举：考虑组合而不是排列
* 枚举2：各个数字的个数*/
public class dati_样题_花朵数 {
  //存储0-9这10个数的21次方
  static HashMap<Integer, BigInteger> map = new HashMap<Integer, BigInteger>();
  private static List list = new ArrayList();

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      map.put(i, BigInteger.valueOf(i).pow(21));
    }

    for (int i9 = 0; i9 <= 21; i9++) {
      for (int i8 = 0; i8 + i9 <= 21; i8++) {
        for (int i7 = 0; i7 + i8 + i9 <= 21; i7++) {
          for (int i6 = 0; i6 + i7 + i8 + i9 <= 21; i6++) {
            for (int i5 = 0; i5 + i6 + i7 + i8 + i9 <= 21; i5++) {
              for (int i4 = 0; i4 + i5 + i6 + i7 + i8 + i9 <= 21; i4++) {
                for (int i3 = 0; i3 + i4 + i5 + i6 + i7 + i8 + i9 <= 21; i3++) {
                  for (int i2 = 0; i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 <= 21; i2++) {
                    for (int i1 = 0; i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 <= 21; i1++) {
                      for (int i0 = 0; i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 <= 21; i0++) {
                        BigInteger sum = map.get(9).multiply(BigInteger.valueOf(i9))
                            .add(map.get(8).multiply(BigInteger.valueOf(i8)))
                            .add(map.get(7).multiply(BigInteger.valueOf(i7)))
                            .add(map.get(6).multiply(BigInteger.valueOf(i6)))
                            .add(map.get(5).multiply(BigInteger.valueOf(i5)))
                            .add(map.get(4).multiply(BigInteger.valueOf(i4)))
                            .add(map.get(3).multiply(BigInteger.valueOf(i3)))
                            .add(map.get(2).multiply(BigInteger.valueOf(i2)))
                            .add(map.get(1).multiply(BigInteger.valueOf(i1)));
                        char[] chars1 = sum.toString().toCharArray();
                        if (chars1.length > 21) continue;
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < i0; i++) {
                          sb.append("0");
                        }
                        for (int i = 0; i < i1; i++) {
                          sb.append("1");
                        }
                        for (int i = 0; i < i2; i++) {
                          sb.append("2");
                        }
                        for (int i = 0; i < i3; i++) {
                          sb.append("3");
                        }
                        for (int i = 0; i < i4; i++) {
                          sb.append("4");
                        }
                        for (int i = 0; i < i5; i++) {
                          sb.append("5");
                        }
                        for (int i = 0; i < i6; i++) {
                          sb.append("6");
                        }
                        for (int i = 0; i < i7; i++) {
                          sb.append("7");
                        }
                        for (int i = 0; i < i8; i++) {
                          sb.append("8");
                        }
                        for (int i = 0; i < i9; i++) {
                          sb.append("9");
                        }
                        char[] chars2 = sb.toString().toCharArray();
                        Arrays.sort(chars1);
                        Arrays.sort(chars2);
                        if (new String(chars1).equals(new String(chars2)))
                          list.add(sum.toString());
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
    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i));
    }
  }

  private static void m1() {
    int cnt = 0;
    for (int a = 9; a > 0; a--) {
      for (int b = a; b >= 0; b--) {
        for (int c = b; c >= 0; c--) {
          for (int d = c; d >= 0; d--) {
            for (int e = d; e >= 0; e--) {
              for (int f = e; f >= 0; f--) {
                for (int g = f; g >= 0; g--) {
                  for (int h = g; h >= 0; h--) {
                    for (int i = h; i >= 0; i--) {
                      for (int j = i; j >= 0; j--) {
                        for (int k = j; k >= 0; k--) {
                          for (int l = k; l >= 0; l--) {
                            for (int m = l; m >= 0; m--) {
                              for (int n = m; n >= 0; n--) {
                                for (int o = n; o >= 0; o--) {
                                  for (int p = o; p >= 0; p--) {
                                    for (int q = p; q >= 0; q--) {
                                      for (int r = q; r >= 0; r--) {
                                        for (int s = r; s >= 0; s--) {
                                          for (int t = s; t >= 0; t--) {
                                            for (int u = t; u >= 0; u--) {
                                              cnt++;
                                              BigInteger sum = map.get(a).add(map.get(b)).add(map.get(c))
                                                  .add(map.get(d)).add(map.get(e)).add(map.get(f))
                                                  .add(map.get(h)).add(map.get(i)).add(map.get(j))
                                                  .add(map.get(k)).add(map.get(l)).add(map.get(m))
                                                  .add(map.get(n)).add(map.get(o)).add(map.get(p))
                                                  .add(map.get(q)).add(map.get(r)).add(map.get(s))
                                                  .add(map.get(t)).add(map.get(u)).add(map.get(g));
                                              char[] chars1 = sum.toString().toCharArray();
                                              if (chars1.length > 21) continue;
                                              char[] chars2 = new StringBuilder().append(a).append(b).append(c)
                                                  .append(d).append(e).append(f)
                                                  .append(g).append(h).append(i)
                                                  .append(j).append(k).append(l)
                                                  .append(m).append(n).append(o)
                                                  .append(p).append(q).append(r)
                                                  .append(s).append(t).append(u).toString().toCharArray();
                                              Arrays.sort(chars1);
                                              Arrays.sort(chars2);
                                              if (new String(chars1).equals(new String(chars2)))
                                                list.add(sum.toString());

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
    }
    System.out.println(cnt);
    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i));
    }
  }
}
