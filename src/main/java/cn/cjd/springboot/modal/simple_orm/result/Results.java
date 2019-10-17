package cn.cjd.springboot.modal.simple_orm.result;


import cn.cjd.springboot.modal.simple_orm.sysException.EventCode;

/**
 * Created by 170096 on 2017/8/15
 */
public class Results {

    public static ResultBean<Object> success(Object object) {
        ResultBean<Object> result = new ResultBean<>();
        result.setCode("0");
        result.setMessage("success");
        result.setData(object);
        return result;
    }

    public static ResultBean<Object> success() {
        return success(null);
    }

    public static ResultBean failed(String code, String message) {
        ResultBean result = new ResultBean();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static ResultBean failed(EventCode eventCode) {
        ResultBean result = new ResultBean();
        result.setCode(eventCode.getCode());
        result.setMessage(eventCode.getMsg());
        return result;
    }

}
