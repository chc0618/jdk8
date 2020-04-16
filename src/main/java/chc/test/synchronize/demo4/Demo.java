package chc.test.synchronize.demo4;

import java.util.concurrent.TimeUnit;

public class Demo {
    // 1. mesi cpu缓存一致性协议   2. 指令重排  happen before
    volatile boolean running = true;
    public void test(){
        System.out.println("test start ...");
        while(running){
            System.out.println("test running ");
        }
        System.out.println("testt end ...");
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        new Thread(demo :: test, "t1").start();

        TimeUnit.SECONDS.sleep(1);
        demo.running = false;

    }

}
