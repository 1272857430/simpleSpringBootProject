package com.modal.common.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({"unused", "WeakerAccess"})
public class HttpHeaderUtil {

    private HttpHeaderUtil() {}

    public static HttpServletResponse getResponse() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if(ra != null) {
            ServletRequestAttributes sra = (ServletRequestAttributes)ra;
            return sra.getResponse();
        } else {
            return null;
        }
    }

    public static HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if(ra != null) {
            ServletRequestAttributes sra = (ServletRequestAttributes)ra;
            return sra.getRequest();
        } else {
            return null;
        }
    }

    public static String getUserId(){
        HttpServletRequest request = getRequest();
        if (request != null) {
            return request.getHeader("user_id");
        }
        return "";
    }
}
