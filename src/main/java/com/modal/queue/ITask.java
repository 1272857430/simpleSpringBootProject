package com.modal.queue;

/**
 * Created by Yan Zhenjie on 2017/5/12.
 */
public interface ITask extends Comparable<ITask> {

    void run();

    void setPriority(Priority priority);

    Priority getPriority();

    void setSequence(int sequence);

    int getSequence();

    void setRunTimes(int runTimes);

    int getRunTimes();

    String getId();
}

