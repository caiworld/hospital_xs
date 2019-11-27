package com.caihao.hospitalmanager;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/6/18 21:24
 */
public class Student implements Comparable{

  String name;
  int age;

  public Student() {
  }

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public int hashCode() {
    return this.name.length()+age;
  }

  @Override
  public boolean equals(Object obj) {
    Student stu = (Student) obj;
    return this.name.equals(stu.name);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  @Override
  public int compareTo(Object o) {
    return this.name.length() - ((Student)o).name.length();
  }
}
