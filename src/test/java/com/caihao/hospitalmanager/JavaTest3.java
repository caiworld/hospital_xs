package com.caihao.hospitalmanager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/30 22:08
 */
public class JavaTest3 {


  public static void main(String[] args) {

    List<String> list = new LinkedList<>();
    list.add("hello");
    list.add("word");
    list.add("java");
    list.add(null);
    list.add(null);
    for (String s : list) {
      System.out.println(s);
    }

    System.out.println("---------------------");

    Set<Student> hashSet = new TreeSet<>();
    hashSet.add(new Student("cai",1));
    hashSet.add(new Student("cai",1));
    hashSet.add(new Student("caa",2));
    hashSet.add(null);
    for (Student o : hashSet) {
      System.out.println(o);
    }
    System.out.println("------------------------");
    TreeMap<Integer,String> map = new TreeMap();
    map.put(2,"a");
    map.put(3,"a");
    map.put(1,"a");
    map.put(4,"a");
    Set<Integer> keys = map.keySet();
    for (Integer key : keys) {
      System.out.println(key+";"+map.get(key));
    }
    System.out.println("---------------------");
    String c = "aa";
    String d = "aa";
    String a = new String("aa");
    String b = new String("aa");
    System.out.println("a==b:" + (a == b));
    System.out.println("a==c:" + (a == c));
    System.out.println("a==d:" + (a == d));
    System.out.println("b==c:" + (b == c));
    System.out.println("b==d:" + (b == d));
    System.out.println("c==d:" + (c == d));
    JavaTest3 test3 = new JavaTest3();
    Student1 s1 = test3.new Student1("caihao", 22);
    Student1 s2 = test3.new Student1("caihao", 22);
    Student1 s3 = test3.new Student1("", 10);
    HashSet<Student1> set = new HashSet<>();
    set.add(s1);
    set.add(s2);
//    set.add(null);
    set.add(s3);
    set.add(null);
    for (Student1 s : set) {
      System.out.println(s);
    }
    test3.test1(s3);
    System.out.println("原s3:" + s3);
  }

  public void test1(Student1 student1) {
    student1 = new Student1("张三", 23);
    System.out.println("改："+student1);
  }

  class Student1 {

    public Student1(String name, int age) {
      this.name = name;
      this.age = age;
    }

    String name;
    int age;

    @Override
    public boolean equals(Object obj) {
      if (obj == null) {
        return false;
      }
      return Objects.equals(this.name, ((Student1) obj).name) && this.age == ((Student1) obj).age;
    }

    @Override
    public int hashCode() {
      return stringHashCode(this.name) + (this.age % 2);
    }

    public int stringHashCode(String value) {
      int h = 0;
      if (value.length() > 0) {
        char val[] = value.toCharArray();

        for (int i = 0; i < value.length(); i++) {
          h = 31 * h + val[i];
        }
      }
      return h;
    }

    @Override
    public String toString() {
      return "Student1{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

}
