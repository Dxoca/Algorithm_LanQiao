package org.lanqiao.algo.elementary._09_Linear._01_oop;

public class Student {
  protected String name;

  public int getAge() {
    return age;
  }

  protected int age;
  protected int ability;

  private Teacher teacher;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void study() {
    ability++;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", ability=" + ability +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Student student = (Student) o;

    return name.equals(student.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  public static void main(String[] args) {
    Student stu1 = new Student("唐僧", 200);
    Student stu3 = new Student("唐僧", 200);
    Student stu2 = new Student("悟空", 600);
    stu1.study();
    stu1.study();

    stu2.study();

    System.out.println(stu1.toString());
    System.out.println(stu2.toString());

    System.out.println(stu1.equals(stu3));
  }
}
