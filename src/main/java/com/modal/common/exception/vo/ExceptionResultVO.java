package com.modal.common.exception.vo;

/**
 * Created by 170096 on 2018/8/29
 */
public class ExceptionResultVO {
    private int resultCode;
    private ErrorInfoVO errorInfo;
    private String traceId;

    public ExceptionResultVO() {
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public ErrorInfoVO getErrorInfo() {
        return this.errorInfo;
    }

    public void setErrorInfo(ErrorInfoVO errorInfo) {
        this.errorInfo = errorInfo;
    }
}
