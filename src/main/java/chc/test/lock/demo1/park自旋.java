package chc.test.lock.demo1;

import java.util.Queue;
import java.util.concurrent.locks.LockSupport;

public class park自旋 {
    volatile int status = 0;
    Queue parkQueue; //

    void lock(){
        while(!compareAndSet(0,1)){
            //
            park();
        }
        unlock();
    }

    private void park() {
        // 将当前线程加入到等待队列
        parkQueue.add(Thread.currentThread());
        // 将当前线程释放cpu， 阻塞
        releaseCpu();
    }

    private void releaseCpu() {
    }

    void unlock(){
        status = 0;
        lock_notify();
    }

    private void lock_notify() {
        // 得到要唤醒的线程头部线程
        Thread t = (Thread) parkQueue.peek();
        // 唤醒等待线程
        LockSupport.unpark(t);
    }

    private boolean compareAndSet(int except, int newValue) {

        return true;
    }
}
