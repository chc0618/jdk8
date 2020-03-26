package chc.test.synchronize.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 ： 实现一个容器，提供两个方法， add， size
 * 写两个线程， 线程1 添加10个元素到容器中， 线程2 实现监控元素的个数
 * 当个数到5个时， 线程2给出提示并结束线程2
 */
public class Container2 {
    List list = new ArrayList();

    public void add(Object object){
        list.add(object);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Container2 container1 = new Container2();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock){
                System.out.println("thread 1 start .....");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
                System.out.println("thread 1 end ...");
            }
        }, "thread 1").start();
        new Thread(() -> {
            synchronized (lock){
                System.out.println("thread 2 start ....");
                for(int i = 0; i < 10; i++){
                    container1.add(new Object());
                    if(container1.size() == 5){
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("thread 2 list.size " + container1.size());
                }
                System.out.println("thread 2 end ....");
            }
        }, "thread 2").start();

    }
}
