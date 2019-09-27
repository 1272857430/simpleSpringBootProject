package cn.cjd.springboot.modal.common.exception.vo;


import cn.cjd.springboot.modal.common.exception.conf.ExceptionInfo;

/**
 * Created by 170096 on 2018/8/29
 */
public class ErrorInfoVO {
    private String errorCode;
    private String errorMsg;
    private String description;
    private String tip;
    private String stackTrace;

    public ErrorInfoVO(ExceptionInfo exceptionInfo, String stackTrace) {
        this.errorCode = exceptionInfo.getErrorCode();
        this.errorMsg = exceptionInfo.getMessage();
        this.description = exceptionInfo.getDescription();
        this.tip = exceptionInfo.getTip();
        this.stackTrace = stackTrace;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTip() {
        return this.tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
