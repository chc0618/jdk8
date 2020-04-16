package chc.test.javase.thread;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPool threadPool = ThreadPool.getThreadPool(3);
        threadPool.execute(new Runnable[]{new Tash(), new Tash(), new Tash()});
        threadPool.execute(new Runnable[]{new Tash(), new Tash(), new Tash()});
        System.out.println(threadPool);
        threadPool.destroy();
        System.out.println(threadPool);
    }

    static private class Tash implements Runnable {
        private static volatile int i = 1;
        @Override
        public void run() {
            System.out.println("任务" + (i++) + "完成");
        }
    }
}
