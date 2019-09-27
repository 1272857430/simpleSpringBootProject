package com.modal.queue;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by Yan Zhenjie on 2017/5/12.
 */
public abstract class BasicTask implements ITask {

    private int sequence;

    private Priority priority = Priority.DEFAULT;

    private int runTimes = 0;

    private String id = UUID.randomUUID().toString().replaceAll("-", "");

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public int getSequence() {
        return sequence;
    }

    @Override
    public void setRunTimes(int runTimes) {
        this.runTimes = runTimes;
    }

    @Override
    public int getRunTimes() {
        return this.runTimes;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicTask basicTask = (BasicTask) o;
        return id.equals(basicTask.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(ITask another) {
        final Priority me = this.getPriority();
        final Priority it = another.getPriority();
        return me == it ? this.getSequence() - another.getSequence() : it.ordinal() - me.ordinal();
    }
}
