package org.lanqiao.algo.elementary._10_hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**简化版本的布隆过滤器的实现*/
public class BloomFilter {
  public static final int NUM_SLOTS = 1024 * 1024 * 8;//位图的长度
  public static final int NUM_HASH = 8;//hash函数的个数，一个hash函数的结果用于标记一个位
  private BigInteger bitmap = new BigInteger("0");//位图

  public static void main(String[] args) {
    //测试代码
    BloomFilter bf = new BloomFilter();
    ArrayList<String> contents = new ArrayList<>();
    contents.add("sldkjelsjf");
    contents.add("ggl;ker;gekr");
    contents.add("wieoneomfwe");
    contents.add("sldkjelsvrnlkjf");
    contents.add("ksldkflefwefwefe");

    for (int i = 0; i < contents.size(); i++) {
      bf.addElement(contents.get(i));
    }
    System.out.println(bf.check("sldkjelsvrnlkjf"));
    System.out.println(bf.check("sldkjelnlkjf"));
    System.out.println(bf.check("ggl;ker;gekr"));
  }

  /**将message+n映射到0~NUM_SLOTS-1之间的一个值*/
  private int hash(String message, int n) {
    message = message + String.valueOf(n);
    try {
      MessageDigest md5 = MessageDigest.getInstance("md5");//将任意输入映射成128位（16个字节）整数的hash函数
      byte[] bytes = message.getBytes();
      md5.update(bytes);
      byte[] digest = md5.digest();
      BigInteger bi = new BigInteger(digest);//至此，获得message+n的md5结果（128位整数）

      return Math.abs(bi.intValue()) % NUM_SLOTS;
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(BloomFilter.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -1;
    // return (int)Math.abs(HashFunctions.bernstein(message,NUM_SLOTS));
  }

  /*处理原始数据
  * 1.hash1(msg)标注一个位……  hash的值域0~NUM_SLOTS-1
  * */
  public void addElement(String message) {
    for (int i = 0; i < NUM_HASH; i++) {
      int hashcode = hash(message, i);//代表了hash1，hash2……hash8
      //结果，用于标注位图的该位为1
      if (!bitmap.testBit(hashcode)) {//如果还不为1
        //标注位图的该位为1
        bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
      }
    }

  }

  public boolean check(String message) {
    for (int i = 0; i < NUM_HASH; i++) {
      int hashcode = hash(message, i);
      //hashcode代表一个位置
      if (!this.bitmap.testBit(hashcode)) {
        //如果位图的该位为0，那么message一定不存在
        return false;
      }
    }
    return true;//不精确，有可能误判
  }
}
