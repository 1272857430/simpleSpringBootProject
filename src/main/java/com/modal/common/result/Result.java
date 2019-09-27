package com.modal.common.result;

import com.modal.common.exception.conf.ExceptionInfo;

import java.util.Map;

/**
 * Created by 170096 on 2018/8/29
 */
public class Result {

    private static final long serialVersionUID = -2061886362019159930L;
    private Integer resultCode;
    private String resultMsg;
    private Long totalNum;
    private Boolean isPage;
    private Integer totalPage;
    private Integer pageSize;
    private Integer pageNum;
    private Object data;
    private ExceptionInfo exceptionInfo;
    private Map<String, Object> extInfo;

    public Result() {
    }

    public Map<String, Object> getExtInfo() {
        return this.extInfo;
    }

    public void setExtInfo(Map<String, Object> extInfo) {
        this.extInfo = extInfo;
    }

    public Boolean getPage() {
        return this.isPage;
    }

    public void setPage(Boolean page) {
        this.isPage = page;
    }

    public ExceptionInfo getExceptionInfo() {
        return this.exceptionInfo;
    }

    public void setExceptionInfo(ExceptionInfo exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Long getTotalNum() {
        return this.totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Boolean getIsPage() {
        return this.isPage;
    }

    public void setIsPage(Boolean isPage) {
        this.isPage = isPage;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
