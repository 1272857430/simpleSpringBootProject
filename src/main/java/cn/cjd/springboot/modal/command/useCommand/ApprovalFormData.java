package cn.cjd.springboot.modal.command.useCommand;

import lombok.Data;

@Data
public class ApprovalFormData {
    private String leaseId;
    private Boolean approval;
    private Boolean isTenantConfirm;

    public ApprovalFormData(){
    }

    public ApprovalFormData(String leaseId, Boolean approval, Boolean isTenantConfirm) {
        this.leaseId = leaseId;
        this.approval = approval;
        this.isTenantConfirm = isTenantConfirm;
    }
}

