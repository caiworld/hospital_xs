package com.caihao.hospitalmanager;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author caihao
 * @date 2019/3/3 17:32
 */
public class JavaTest{
  @Test
  public void testStringArraySort() {

  }

  public static void main(String[] args) {
    String[] s = {"a", "bc", "ac", "dda", "bac"};
    Arrays.sort(s, new MyComparator()::compare);
    for (String s1 : s) {
      System.out.println(s1);
    }
  }

}
class MyComparator implements Comparator{
  @Override
  public int compare(Object o1, Object o2) {
    return o1.toString().length() - o2.toString().length();
  }
}
