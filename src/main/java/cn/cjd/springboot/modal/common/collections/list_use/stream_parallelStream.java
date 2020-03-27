package cn.cjd.springboot.modal.common.collections.list_use;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class stream_parallelStream {

    public static void main(String[] args) throws InterruptedException {
        //模拟10000条数据 forEach打印测试
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 10000; j++) {
            list.add(j);
        }
        useFor(list);
        userStream(list);
        userParallelStream(list);
    }

    private static void userParallelStream(List<Integer> list) {
        // 测试多管道parallelStream执行效率
        long startTime = System.currentTimeMillis();
        list.parallelStream().forEach(r -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//睡眠1毫秒
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long parallelStreamendTime = System.currentTimeMillis();
        System.out.println("parallelStream : " + (parallelStreamendTime - startTime) + "ms");
    }

    private static void userStream(List<Integer> list) {
        // 测试单管道stream执行效率
        long startTime = System.currentTimeMillis();
        list.stream().forEach(r -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//睡眠1毫秒
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        long streamEndTime = System.currentTimeMillis();
        System.out.println("stream : " + (streamEndTime - startTime) + "ms");
    }

    private static void useFor(List<Integer> list){
        //下面测试下各方法执行的时间 检查效率
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//睡眠1毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("传统for循环运行时间:" + (endTime - startTime) + "ms");
    }
}
