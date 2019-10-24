package cn.cjd.springboot.modal.thread.futureTask;

import java.util.concurrent.Callable;

// 定义一个我的任务，实现Callable接口
public class MyTask implements Callable<Object> {

    private String args1;
    private String args2;

    public MyTask(String args1, String args2) {
        this.args1 = args1;
        this.args2 = args2;
    }

    // 任务处理的内容
    @Override
    public Object call() throws Exception {
        String result = "";

        for (int i = 0; i < 5 ; i++) {
            Thread.currentThread().sleep(1000);
            result += "args1=" + args1 + "-" + "args2=" +  args1;
        }
        return result;
    }
}
