package chc.test.lock.demo1;

public class SynchronizeTest {
    public synchronized void test1(){

    }
    public void test2(){
        synchronized(this){

        }
    }

    public static void main(String[] args) {
        System.out.println("Synchronize test");
    }
}
