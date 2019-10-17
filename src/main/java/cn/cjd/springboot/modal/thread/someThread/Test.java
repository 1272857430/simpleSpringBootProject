package cn.cjd.springboot.modal.thread.someThread;

/**
 * Created by 170096 on 2019/2/20 9:36
 *
 * @author ${User}
 */
public class Test {

    private static CommonLock commonLock;

    public static void main(String[] args) {
        commonLock = new CommonLock(1);
        Thread thread1 = new Thread(new RunSay(commonLock, 1, 2), "thread1");
        Thread thread2 = new Thread(new RunSay(commonLock, 2, 3), "thread2");
        Thread thread3 = new Thread(new RunSay(commonLock, 3, 4), "thread3");
        Thread thread4 = new Thread(new RunSay(commonLock, 4, 5), "thread4");
        Thread thread5 = new Thread(new RunSay(commonLock, 5, 1), "thread5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


}
