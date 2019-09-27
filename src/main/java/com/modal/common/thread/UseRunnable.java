package com.modal.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 170096 on 2018/10/10 10:38
 *
 * @author ${User}
 */
public class UseRunnable implements Runnable {

    private String word;
    private int delay;

    public UseRunnable (String whatToSay, int delayTime) {
        this.word = whatToSay;
        this.delay = delayTime;
    }

    @Override
    public void run() {

        for (;;) {
            System.out.print("threadName: " + Thread.currentThread().getName());
            System.out.println("word: " + word);
        }
    }

    public static void main(String[] args) {
        UseRunnable runnable1 = new UseRunnable("1秒", 1000);
        UseRunnable runnable2 = new UseRunnable("2秒", 2000);

//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("demo-pool-%d").build();
//        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
//        singleThreadPool.shutdown();

        runnable1.run();
        runnable2.run();
        new Thread(runnable1).start();
    }
}
