package cn.cjd.springboot.modal.queue;

import com.modal.common.utils.SpringContextUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

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
