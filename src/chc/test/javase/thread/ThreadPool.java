package chc.test.javase.thread;

import java.util.LinkedList;
import java.util.List;

public final class ThreadPool {

    // 线程池中默认线程的个数
    private static int worker_num = 5;
    // 工作线程
    private WorkThread[] workThreads;
    // 未处理的任务
    private static volatile int finished_tash = 0;
    private List<Runnable> tashQueue = new LinkedList<>();
    private static ThreadPool threadPool;

    // 创建具有默认线程个数的线程池
    private ThreadPool(){
        this(5);
    }

    // 创建线程池 worker_num 为线程池中的工作线程个数
    public ThreadPool(int worker_num) {
        ThreadPool.worker_num = worker_num;
        workThreads = new WorkThread[worker_num];
        for (int i = 0; i < worker_num; i++) {
            workThreads[i] = new WorkThread();
            workThreads[i].start(); // 开启线程池中的线程
        }
    }

    public static ThreadPool getThreadPool(){
        return getThreadPool(ThreadPool.worker_num);
    }

    // 单例模式 获得一个指定线程个数的线程池 ， work_num > 0 线程池个数为work_num
    // work_num <= 0 线程池个数为默认线程个数
    public static ThreadPool getThreadPool(int worker_num) {
        if (worker_num <= 0) {
            worker_num = ThreadPool.worker_num;
        }
        if(threadPool == null){
            threadPool = new ThreadPool(worker_num);
        }
        return threadPool;
    }

    // 把任务放入队列 什么时候执行 线程池管理器决定
    public void execute(Runnable runnable) {
        synchronized (tashQueue) {
            tashQueue.add(runnable);
            tashQueue.notify();
        }
    }

    public void execute (Runnable[] runnables) {
        synchronized (tashQueue) {
            for(Runnable r : runnables){
                tashQueue.add(r);
            }
            tashQueue.notify();
        }
    }

    public void execute (List<Runnable> runnableList) {
        synchronized (tashQueue) {
            for (Runnable r : runnableList) tashQueue.add(r);
            tashQueue.notify();
        }
    }

    public void destroy() {
        while(!tashQueue.isEmpty()){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < worker_num; i++) {
                workThreads[i].stopWorker();
                workThreads[i] = null;
            }
            threadPool = null;
            tashQueue.clear();
        }
    }

    public int getWorkThreadNum () {
        return worker_num;
    }

    public int getFinishedTask () {
        return finished_tash;
    }

    public int getWaitTashNumber() {
        return tashQueue.size();
    }

    @Override
    public String toString() {
        return  "WorkThread number:" + getWorkThreadNum() + "  finished task number:"
                + getFinishedTask() + "  wait task number:" + getWaitTashNumber();
    }



    private class WorkThread extends Thread{

        private boolean isRunning = true;

        @Override
        public void run() {
            Runnable r = null;
            while (isRunning) {
                synchronized (tashQueue) {
                    if (isRunning
                            && tashQueue.isEmpty()) {
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                    if (!tashQueue.isEmpty()) {
                        r = tashQueue.remove(0);
                    }
                }
                if(r != null){
                    r.run();
                }
                finished_tash++;
                r = null;
            }
        }

        public void stopWorker() {
            isRunning = false;
        }
    }


}
