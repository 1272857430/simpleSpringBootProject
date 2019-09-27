package cn.cjd.springboot.modal.common.restTemplate;

import cn.cjd.springboot.modal.common.utils.simpleUtils.StringUtils;

/**
 *
 * Created by 170096 on 2018/8/7
 */
public enum Methods {

    POST("post", "post"),
    PUT("put", "put"),
    DELETE("delete", "delete"),
    GET("get", "get");

    private String code;

    private String value;

    Methods(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueByCode(String code) {
        if (StringUtils.isNullOrBlank(code)) {
            return null;
        }
        for (Methods methods : Methods.values()) {
            if (code.equals(methods.code)) {
                return methods.getValue();
            }
        }
        return null;
    }
}
