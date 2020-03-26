package chc.test.synchronize.demo3;

import java.util.concurrent.TimeUnit;

public class Demo {
    int count = 0;
    synchronized void test(){
        System.out.println(Thread.currentThread().getName() + "start .....");
        while(true){
            count ++;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (count == 5) {
                    int i = 1 / 0;   // 抛出异常 不处理的话 会释放锁
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Runnable r = () -> demo.test();
        new Thread(r, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->demo.test(), "t2").start();
    }
}
