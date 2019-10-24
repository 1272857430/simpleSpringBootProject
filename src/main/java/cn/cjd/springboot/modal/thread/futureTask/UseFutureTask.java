package cn.cjd.springboot.modal.thread.futureTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class UseFutureTask {



    public static void main(String[] args) {
        MyTask myTask = new MyTask("1", "2");
//        useFutureTask1(myTask);
//        useFutureTask2(myTask);
        useFutureTask3();
    }


    /**
     * 多任务，多线程执行，并依次获取执行结果
     */
    private static void useFutureTask3(){
        // TODO 创建一个FutureTask list来放置所有的任务
        List<FutureTask<Object>> futureTasks=new ArrayList<>();
        for(int i = 0; i<10; i++){
            MyTask myTask=new MyTask(Integer.toString(i), Integer.toString(i));
            futureTasks.add(new FutureTask<>(myTask));
        }

        // TODO 创建线程池后，依次的提交任务，执行
        ExecutorService executorService=Executors.newCachedThreadPool();
        for(FutureTask<Object> futureTask:futureTasks){
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        // TODO 根据任务数，依次的去获取任务返回的结果，这里获取结果时会依次返回，若前一个没返回，则会等待，阻塞
        for(int i = 0; i<10; i++){
            try {
                String flag=(String)futureTasks.get(i).get();
                System.out.println(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * FutureTask使用方法2
     */
    private static void useFutureTask2(MyTask myTask) {
        FutureTask<Object> futureTask = new FutureTask<>(myTask);
        // TODO 采用线程池来启动处理
        ExecutorService executorService= Executors.newCachedThreadPool();
        // 提交任务
        executorService.submit(futureTask);
        // 停止提交任务
        executorService.shutdown();
        PrintFutureTaskRasult(futureTask);
    }


    /**
     * FutureTask使用方法1
     */
    private static void useFutureTask1(MyTask myTask) {
        FutureTask<Object> futureTask = new FutureTask<>(myTask);
        // TODO 采用Thread来开启多线程，futuretask继承了Runnable，可以放在线程池中来启动执行
        Thread thread = new Thread(futureTask);
        thread.start();
        PrintFutureTaskRasult(futureTask);
    }


    private static void PrintFutureTaskRasult(FutureTask<Object> futureTask) {
        try {
            // TODO get():获取任务执行结果，如果任务还没完成则会阻塞等待直到任务执行完成。如果任务被取消则会抛出CancellationException异常。

            // TODO 如果任务执行过程发生异常则会抛出ExecutionException异常，如果阻塞等待过程中被中断则会抛出InterruptedException异常。
            Object result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
