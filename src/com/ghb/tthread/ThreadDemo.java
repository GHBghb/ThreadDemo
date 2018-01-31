package com.ghb.tthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadDemo {
    private Semaphore semaphore;// fS号量
    private int user;// 第几个用户

    class MyTask implements Runnable {
        Semaphore semaphore;
        int user;
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("开始排队" + user);
                Thread.sleep((long)Math.random() * 1000);
                System.out.println("排队结束，准备离开 " + user);
                Thread.sleep((long)Math.random() * 10000);
                System.out.println("已经离开，下一个进场");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public MyTask(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }
    }
    private void execute(){

        final Semaphore s = new Semaphore(2);

        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            threadPool.execute(new MyTask(s, (i +1))); }
        threadPool.shutdown();
    }

    public static void main (String [ ] args) {
        ThreadDemo demo = new ThreadDemo();
        demo.execute();
    }


}

