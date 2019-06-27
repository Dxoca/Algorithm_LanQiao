package org.lanqiao.algo.elementary.datastructure;

import java.util.Arrays;

public class Huffman {
  //存在以下字母串：AGDCCDDDGFBBFFGGDDDGGGEFFDDCCCDDDFGAAA现在需要对该串进行huffman编码，
  //那么字母F对应bit值（二进制格式为）（）
  //10  11  110  101right
  public static void main(String[] args) {
    char[] charArray = "AGDCCDDDGFBBFFGGDDDGGGEFFDDCCCDDDFGAAA".toCharArray();
    Arrays.sort(charArray);
    System.out.println(charArray);
//    AAAABBCCCCCDDDDDDDDDDDDEFFFFFFGGGGGGGG
//    A-4 B-2 C-5 D-12 E-1 F-6 G-8
//    选择最小的两个节点作为子节点，相加形成一个虚的父节点，
//    删除子节点，将父节点添加到列表中递归上一步
//    1
//        （3）
//    2       （7）
//         4        （15）
//             8
//                            （38）
//         5
//            （11）
//         6        （23）
//             12
//    
      }
  
}
