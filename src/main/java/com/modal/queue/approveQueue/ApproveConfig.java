package com.modal.queue.approveQueue;

import com.modal.queue.TaskQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApproveConfig {

    @Bean("approveTaskQueue")
    public TaskQueue approveTaskQueue(){
        return new TaskQueue(3);
    }


}
