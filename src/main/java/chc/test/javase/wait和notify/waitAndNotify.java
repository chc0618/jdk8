package chc.test.javase.wait和notify;

public class waitAndNotify {

    volatile static int flag = 0;

    volatile static Object lock = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    while (true){
                        if(flag == 0){
                            try {
                                Thread.sleep(2000);
                                System.out.println("线程1等待");
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("线程1运行");
                        System.out.println("线程notify 线程2");
                        flag = 0;
                        lock.notify();
                    }
                }
            }
        }, "线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(lock){
                    while (true) {
                        if(flag == 1){
                            try {
                                Thread.sleep(2000);
                                lock.wait();
                                System.out.println("线程2 等待ing");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("线程2运行");
                        System.out.println("线程2 通知线程1");
                        flag = 1;
                        lock.notify();
                    }
                }

            }
        }, "线程2").start();
    }

}
