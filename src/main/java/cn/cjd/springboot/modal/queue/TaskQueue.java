package cn.cjd.springboot.modal.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Yan Zhenjie on 2017/5/12.
 */
public class TaskQueue {

    private final AtomicInteger mAtomicInteger = new AtomicInteger();
    private final AtomicBoolean runing = new AtomicBoolean(false);

    private final BlockingQueue<ITask> mTaskQueue;
    private final TaskExecutor[] mTaskExecutors;

    public TaskQueue(int size) {
        mTaskQueue = new PriorityBlockingQueue<>();
        mTaskExecutors = new TaskExecutor[size];
    }

    public void start() {
        stop();
        for (int i = 0; i < mTaskExecutors.length; i++) {
            mTaskExecutors[i] = new TaskExecutor(mTaskQueue);
            mTaskExecutors[i].start();
        }

        runing.set(true);
    }

    public void stop() {
        for (TaskExecutor taskExecutor : mTaskExecutors) {
            if (taskExecutor != null) taskExecutor.quit();
        }
        runing.set(false);
    }

    public <T extends ITask> int add(T task) {
        synchronized (mTaskQueue) {
            if (!mTaskQueue.contains(task)) {
                task.setSequence(mAtomicInteger.incrementAndGet());
                mTaskQueue.add(task);
            }
            return mTaskQueue.size();
        }
    }

    public boolean isRuning(){
        return runing.get();
    }

}
