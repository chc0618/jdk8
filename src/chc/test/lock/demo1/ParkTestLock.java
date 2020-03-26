package chc.test.lock.demo1;

import java.util.concurrent.locks.ReentrantLock;

public class ParkTestLock {
    static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        System.out.println("main ------");
        Thread t1 = new Thread(()->{
            lockTest();

        });
        t1.start(); // rubable          not running
        lockTest();
        System.out.println("main ------------------2");
    }

    private static void lockTest() {
        lock.lock();
        System.out.println("t1 ----------1" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end ----------------2");
        lock.unlock();
    }
}
