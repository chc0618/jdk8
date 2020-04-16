package chc.test.synchronize.demo2;

import java.util.concurrent.TimeUnit;

// 重入锁 继承 支持  两种情况  1. 一个方法调用另一个方法  2. 继承
public class Demo extends 重入锁一个方法调用另一个方发 {
    synchronized void test1() {
        System.out.println("demo start -----");
        super.test1();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("demo end -------");
    }

    public static void main(String[] args) {
        new Demo().test1();
    }
}
