package com.modal.queue.approveQueue;

import com.modal.queue.BasicTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApproveTask extends BasicTask {

    private final static Logger logger = LoggerFactory.getLogger(ApproveTask.class);

    @Override
    public void run() {
        if (this.getRunTimes() < 10){
            logger.info("ApproveTask say: " + getId());
        }
    }
}
