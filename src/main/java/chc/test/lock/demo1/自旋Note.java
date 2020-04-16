package chc.test.lock.demo1;

/**
 * 缺点 ； 耗费cpu资源，没有竞争到锁的线程一直占用cpu资源进行cas操作，
 * 假如一个线程获得锁后要花费n秒处理业务逻辑，那另一个线程就会浪费n秒cpu资源
 * 思路： 让得不到的线程让出cpu
 */
public class 自旋Note {

    volatile int status = 0; // 标识 --- 是否有线程在同步块  ---- 是否有线程上锁成功

    void lock(){
        while (!compareAndSet(0,1)){

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
