package cn.cjd.springboot.modal.queue;

import cn.cjd.springboot.modal.common.utils.springContext.SpringContextUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    /**
     * CommandLineRunner 项目启动时，执行的任务
     */
    @Bean("initQueue")
    public CommandLineRunner initQueue() {
        return (String... strings) -> {
            TaskQueue taskQueue = SpringContextUtils.getBean(TaskQueue.class);
            if(!taskQueue.isRuning()){
                taskQueue.start();
            }
        };
    }
}
