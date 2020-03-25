package cn.cjd.springboot.modal.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.*;

@Component
public class ThreadPoolUtil {
    volatile static ThreadFactory threadFactory;
    volatile static ExecutorService executorService;

    public static ExecutorService getExecutorService() {
        if (null != executorService) {
            return executorService;
        }
        synchronized (ThreadPoolUtil.class) {
            if (Objects.isNull(executorService)) {
                threadFactory = new ThreadFactoryBuilder().build();
                executorService = new ThreadPoolExecutor(10, 10, 30,
                        TimeUnit.SECONDS,
                        new SynchronousQueue<>(),
                        threadFactory,
                        new ThreadPoolExecutor.CallerRunsPolicy());
            }
        }
        return executorService;
    }


}

