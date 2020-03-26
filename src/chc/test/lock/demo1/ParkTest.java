package chc.test.lock.demo1;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println("main ------");
        Thread t1 = new Thread(()->{
            System.out.println("t1 ----------1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 ----------------2");
            LockSupport.unpark(main);

        });
        t1.start(); // rubable          not running
        LockSupport.park();  // 让当前线程 阻塞挂起
        System.out.println("main ------------------2");
    }
}
