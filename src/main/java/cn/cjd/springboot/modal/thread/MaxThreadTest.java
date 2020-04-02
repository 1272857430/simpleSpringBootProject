package cn.cjd.springboot.modal.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * -Xms     intial java heap size初始化内存大小
 * -Xmx     maximum java heap size最大内存大小
 * -Xss     the stack size for each thread每个线程栈的大小
 * -Xmn     设置年轻代大小为2G。整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小。
 *          持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。
 *          此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8。
 * 系统限制  系统最大可开线程数
 *
 * cpu核数和最大线程数的关系：
 *      对于一个CPU，线程数总是大于或等于核心数的。一个核心最少对应一个线程，但通过超线程技术，一个核心可以对应两个线程，也就是说它可以同时运行两个线程
 */

public class MaxThreadTest extends Thread{

    private static final AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        while (true)
            (new MaxThreadTest()).start();

    }

    @Override
    public void run() {
        System.out.println(count.incrementAndGet());

        while (true)
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                break;
            }
    }
}
