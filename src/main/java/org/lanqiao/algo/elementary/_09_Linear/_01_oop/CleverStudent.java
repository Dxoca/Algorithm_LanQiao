package org.lanqiao.algo.elementary._09_Linear._01_oop;

public class CleverStudent extends Student {

  public CleverStudent(String name, int age) {
    super(name, age);
  }

  @Override
  public void study() {
    // super.study();
    // super.study();
    ability += 2;
  }

  public void study(int s) {
    ability += s;
  }
}
