package chc.test.lock.demo1;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

public class yield自旋 {
    volatile int status = 0; // 标识 --- 是否有线程在同步块  ---- 是否有线程上锁成功

    void lock() throws InterruptedException {
        while (!compareAndSet(0,1)){
            /**
             * 让出CPU资源， 自旋+ yield 方式并没解决问题，当系统有两个线程竞争锁时，yield是有效的，需要注意的是只是让出cpu
             * 有可能操作系统下次还是选择运行该线程，
             */
            yield();
            /**
             * sleep + 自旋  sleep的时间怎么定义，很多时候不知道是多少
             */
            sleep(10);//
        }
    }
    void unlock(){
        status = 0;
    }

    boolean compareAndSet(int except, int newValue){
        // cas操作， 修改status成功返回true
        return true;
    }

}
