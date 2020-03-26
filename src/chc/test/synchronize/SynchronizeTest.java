package chc.test.synchronize;

public class SynchronizeTest implements Runnable{
    private int count = 10;
    private Object object = new Object();

    public void test0() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }
    public void test(){
        synchronized (object){
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }
    public void test2() {
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

    public void test3(){
        synchronized (SynchronizeTest.class){  // 锁的class文件
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }

    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new SynchronizeTest();
        for(int i = 0; i < 5 ; i++){
            new Thread(synchronizeTest, "THREAD" + i).start();
        }

    }

    @Override
    public void run() {
        test2();
    }
}
