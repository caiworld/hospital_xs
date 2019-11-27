package com.caihao.hospitalmanager;

/**
 * 消失的数据
 *
 * @author caihao
 * @date 2019/3/10 17:05
 */
public class JavaTest2 implements Runnable {
  static volatile int a = 0;
  static JavaTest2 instance = new JavaTest2();

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      synchronized (JavaTest2.class) {
        ++a;
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new Thread(instance);
    Thread thread2 = new Thread(instance);
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println(a);
  }
}