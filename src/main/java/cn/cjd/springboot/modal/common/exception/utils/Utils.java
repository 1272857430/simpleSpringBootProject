package cn.cjd.springboot.modal.common.exception.utils;

import com.modal.common.utils.simpleUtils.HttpHeaderUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 170096 on 2018/8/29
 */
public class Utils {
    public Utils() {
    }

    public static String getTraceId() {
        HttpServletRequest request = HttpHeaderUtil.getRequest();
//        Span span = (Span)request.getAttribute(TraceFilter.class.getName() + ".TRACE");
//        return span.traceIdString();
        return "";
    }
}
