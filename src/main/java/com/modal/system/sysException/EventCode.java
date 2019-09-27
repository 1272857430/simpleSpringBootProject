package com.modal.system.sysException;

/**
 * Created by 170096 on 2017/8/15
 */
public enum EventCode {
    UNKNOWN_ERROR("-1" , "未知错误"),
    PRIMARY_SCHOOL("100","你还在上小学"),
    MIDDLE_SCHOOL("101","你还在上初中"),
    FAILD_OPERATION("200","操作失败"),
    SYSTEM_ABNORMALITY("999","系统异常")
    ;
    private String code;

    private String msg;

    EventCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
