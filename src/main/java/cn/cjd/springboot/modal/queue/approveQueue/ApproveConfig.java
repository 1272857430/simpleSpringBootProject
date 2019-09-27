package cn.cjd.springboot.modal.queue.approveQueue;

import cn.cjd.springboot.modal.queue.TaskQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApproveConfig {

    @Bean("approveTaskQueue")
    public TaskQueue approveTaskQueue(){
        return new TaskQueue(3);
    }


}
