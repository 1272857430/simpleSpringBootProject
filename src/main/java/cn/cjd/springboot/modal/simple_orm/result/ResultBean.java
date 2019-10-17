package cn.cjd.springboot.modal.simple_orm.result;

/**
 * Http请求返回的最外层对象
 * Created by 170096 on 2017/8/15
 */
public class ResultBean<T> {

    //错误码
    private String code;

    //提示信息
    private String message;

    //具体内容
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
