package com.modal.common.thread;

/**
 * Created by 170096 on 2018/10/10 10:15
 *
 * @author ${User}
 */
public class UseThread extends Thread {

    private String word;
    private int delay;

    public UseThread (String whatToSay, int delayTime) {
        super(whatToSay);
        this.word = whatToSay;
        this.delay = delayTime;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.print("threadName: " + Thread.currentThread().getName());
            System.out.println("\tword: " + word);
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        UseThread thread1 = new UseThread("1秒", 1000);
        UseThread thread2 = new UseThread("2秒", 2000);
        thread1.start();
        thread2.start();
    }

    /*
     * start() 和 run() 的区别

        start()方法来启动线程，真正实现了多线程运行。
        这时无需等待run方法体代码执行完毕，可以直接继续执行下面的代码；通过调用Thread类的start()方法来启动一个线程， 这时此线程是处于就绪状态， 并没有运行。
        然后通过此Thread类调用方法run()来完成其运行操作的， 这里方法run()称为线程体，它包含了要执行的这个线程的内容， Run方法运行结束， 此线程终止。
        然后CPU再调度其它线程。


        run()方法当作普通方法的方式调用。
        程序还是要顺序执行，要等待run方法体执行完毕后，才可继续执行下面的代码； 程序中只有主线程——这一个线程， 其程序执行路径还是只有一条， 这样就没有达到写线程的目的。


        记住：多线程就是分时利用CPU，宏观上让所有线程一起执行 ，也叫并发
     */
}
