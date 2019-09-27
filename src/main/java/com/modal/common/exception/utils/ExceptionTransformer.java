package com.modal.common.exception.utils;

import com.modal.common.exception.conf.ExceptionInfo;
import com.modal.common.exception.vo.ErrorInfoVO;
import com.modal.common.exception.vo.ExceptionResultVO;

/**
 * Created by 170096 on 2018/8/29
 */
public class ExceptionTransformer {
    private static final int FAILURE = 1;

    public ExceptionTransformer() {
    }

    public static ExceptionResultVO transform(ExceptionInfo exceptionInfo, String stackTrace) {
        ExceptionResultVO result = new ExceptionResultVO();
        String traceId = Utils.getTraceId();
        result.setTraceId(traceId);
        result.setResultCode(1);
        ErrorInfoVO errorInfo = new ErrorInfoVO(exceptionInfo, stackTrace);
        result.setErrorInfo(errorInfo);
        return result;
    }
}
