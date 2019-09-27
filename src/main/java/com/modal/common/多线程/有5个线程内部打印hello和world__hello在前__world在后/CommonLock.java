package com.modal.common.多线程.有5个线程内部打印hello和world__hello在前__world在后;

/**
 * Created by 170096 on 2019/2/20 16:42
 *
 * @author ${User}
 */
public class CommonLock {

    private int state;

    public CommonLock(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
