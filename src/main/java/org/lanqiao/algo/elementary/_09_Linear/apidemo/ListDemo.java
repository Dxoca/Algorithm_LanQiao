package org.lanqiao.algo.elementary._09_Linear.apidemo;

import org.lanqiao.algo.elementary._09_Linear._01_oop.Student;

import java.util.*;

public class ListDemo {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list = new LinkedList<>();
    list.add("adnda");
    list.add("xyz");
    list.add("def");
    list.remove("");
    //  ......

    Collections.sort(list);

    System.out.println(list);
    List<Student> list1 = new ArrayList<>();
    list1.add(new Student("zhangsan", 10));
    list1.add(new Student("lsii", 20));
    list1.add(new Student("wangwu", 40));
    list1.add(new Student("wangsu", 30));

    Collections.sort(list1, (o1, o2) -> {
      return o1.getAge() - o2.getAge();
    });

    System.out.println(list1);

    for (int i = 0; i < list1.size(); i++) {
      System.out.println(list1.get(i));
    }

    System.out.println("===============");
    for (Student stu : list1) {
      System.out.println(stu);
    }
    System.out.println("++++++++++++++++++++");
    Iterator<Student> iterator = list1.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
