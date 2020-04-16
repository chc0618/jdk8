package chc.test.synchronize.demo2;

import java.util.concurrent.TimeUnit;

public class 重入锁一个方法调用另一个方发 {

    synchronized void test1(){
        System.out.println("test1 start ____");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();
    }

    synchronized void test2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test2 start ------");
    }

    public static void main(String[] args) {
        重入锁一个方法调用另一个方发 c = new 重入锁一个方法调用另一个方发();
        c.test1();
    }
}

