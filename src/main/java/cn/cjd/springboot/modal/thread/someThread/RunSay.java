package cn.cjd.springboot.modal.thread.someThread;

/**
 * Created by 170096 on 2019/2/20 16:48
 *
 * @author ${User}
 */
public class RunSay implements Runnable {

    private CommonLock lock;
    private int currentState;
    private int nextStatus;

    public RunSay(CommonLock lock, int currentState, int nextStatus) {
        this.lock = lock;
        this.currentState = currentState;
        this.nextStatus = nextStatus;
    }

    @Override
    public void run() {
        for (int j=0;j<2;j++){
            synchronized(lock) {
                while (lock.getState()!=currentState) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.setState(nextStatus);
                if (j == 0) {
                    System.out.println(Thread.currentThread().getName()+"  Hello");
                } else if (j == 1) {
                    System.out.println(Thread.currentThread().getName()+"  World");
                }
                lock.notifyAll();
            }
        }

    }
}
