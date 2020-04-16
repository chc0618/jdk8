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

    /**
     * 锁对象：其实就是ReentrantLock的实例对象，下文应用代码第一行中的lock对象就是所谓的锁
     * 自由状态：自由状态表示锁对象没有被别的线程持有，计数器为0
     * 计数器：再lock对象中有一个字段state用来记录上锁次数，比如lock对象是自由状态则state为0，如果大于零则表示被线程持有了，当然也有重入那么state则>1
     * waitStatus：仅仅是一个状态而已；ws是一个过渡状态，在不同方法里面判断ws的状态做不同的处理，所以ws=0有其存在的必要性
     * tail：队列的队尾 head：队列的对首 ts：第二个给lock加锁的线程 tf：第一个给lock加锁的线程 tc：当前给线程加锁的线程
     * tl：最后一个加锁的线程 tn：随便某个线程
     * 当然这些线程有可能重复，比如第一次加锁的时候tf=tc=tl=tn
     * 节点：就是上面的Node类的对象，里面封装了线程，所以某种意义上node就等于一个线程
     */
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
