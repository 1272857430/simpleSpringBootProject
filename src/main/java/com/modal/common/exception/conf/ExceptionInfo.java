package com.modal.common.exception.conf;

/**
 * Created by 170096 on 2018/8/29
 */
public class ExceptionInfo {
    private String errorCode;
    private String message;
    private String description;
    private String tip;
    private String stackTrace;

    public ExceptionInfo() {
    }

    public ExceptionInfo(String errorCode, String message, String description, String tip) {
        this.errorCode = errorCode;
        this.message = message;
        this.description = description;
        this.tip = tip;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
