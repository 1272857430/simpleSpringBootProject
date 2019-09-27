package cn.cjd.springboot.modal.system.sysException;

import cn.cjd.springboot.modal.system.result.ResultBean;
import cn.cjd.springboot.modal.system.result.Results;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 170096 on 2017/8/15
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 全局异常捕获
     *
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBean errorExceptionHandle(Exception ex) {
        ex.printStackTrace();
        return Results.failed(EventCode.SYSTEM_ABNORMALITY);
    }

    /**
     * 自定义异常捕获
     *
     */
    @ResponseBody
    @ExceptionHandler(value = GirlException.class)
    public ResultBean myExceptionHandle(GirlException ge) {
        ge.printStackTrace();
        return Results.failed(ge.getCode(), ge.getMessage());
    }
}
