package chc.test.synchronize.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 面试题 ： 实现一个容器，提供两个方法， add， size
 * 写两个线程， 线程1 添加10个元素到容器中， 线程2 实现监控元素的个数
 * 当个数到5个时， 线程2给出提示并结束线程2
 */
public class Container3 {
    List list = new ArrayList();

    public void add(Object object){
        list.add(object);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Container3 container1 = new Container3();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("thread 1 start .....");
            try {
                if(container1.size() != 5){
                    countDownLatch.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1 end ...");
        }, "thread 1").start();
        new Thread(() -> {
            System.out.println("thread 2 start ....");
            for (int i = 0; i < 10; i++) {
                container1.add(new Object());
                if(container1.size() == 5){
                    countDownLatch.countDown();
                }
                System.out.println("thread 2 list.size " + container1.size());
            }
            System.out.println("thread 2 end ....");
        }, "thread 2").start();

    }
}
