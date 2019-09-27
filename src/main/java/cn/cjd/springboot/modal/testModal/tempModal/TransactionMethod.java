package cn.cjd.springboot.modal.testModal.tempModal;

import org.springframework.transaction.annotation.Transactional;


public class TransactionMethod {

    @Transactional
    public void modalTransactionMethod() {
        System.out.println("modalTransactionMethod");
    }
}
