package cn.cjd.springboot.modal.system.sysException;

/**
 * Created by 170096 on 2017/8/15
 */
public class GirlException extends RuntimeException {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GirlException(EventCode eventCode) {
        super(eventCode.getMsg());
        this.code = eventCode.getCode();
    }
}
