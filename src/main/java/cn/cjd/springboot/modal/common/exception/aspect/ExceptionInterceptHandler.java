package cn.cjd.springboot.modal.common.exception.aspect;

import cn.cjd.springboot.modal.common.exception.SysUnifiedException;
import cn.cjd.springboot.modal.common.exception.conf.ExceptionInfo;
import cn.cjd.springboot.modal.common.exception.utils.ExceptionTransformer;
import cn.cjd.springboot.modal.common.exception.vo.ExceptionResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ExceptionInterceptHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionInterceptHandler.class);
    private static final String IS_OUTER_REQ = "outerReqFlag";
    private static final String DEFAULT_ERROR_CODE = "SCPSBE000001";
    private static final String DEFAULT_ERROR_CODE_STRING = "todoAPI.common.unchecked";
    private static final String DEFAULT_ERROR_MESSAGE = "System error.";
    private static final String MESSAGE = ".message";
    private static final String DESC = ".description";
    private static final String TIP = ".tip";
    @Resource
    private MessageSource messageSource;

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ExceptionResultVO handleUnCheckedException(Exception ex) {
        ex.printStackTrace();
        if(ex instanceof NumberFormatException) {//判断是不是数据转换异常
            System.out.println("NumberFormatException");//输出结果
        }
        else if(ex instanceof NullPointerException) {//判断是不是空指针异常
            System.out.println("NullPointerException");//输出结果
        }else{
            System.out.println(ex.getMessage());//输出结果
        }
        return this.SysUnifiedExceptionHandler(new SysUnifiedException(ex, ExceptionInterceptHandler.DEFAULT_ERROR_CODE));
//        return ObjectToResult.getResult(9999, "系统异常请联系运维人员！");
    }

    /**
     * 拦截捕捉自定义异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = SysUnifiedException.class)
    public ExceptionResultVO SysUnifiedExceptionHandler(SysUnifiedException ex) {
        if(null == ex.getStackTrace() || ex.getStackTrace().length == 0) {
            ex.setStackTrace(Thread.currentThread().getStackTrace());
        }

        ExceptionInfo exceptionInfo = this.getExceptionInfo(ex.getErrorCode(), ex.getArgs());
        StringBuilder message = (new StringBuilder()).append(exceptionInfo.getErrorCode()).append(" ,").append(exceptionInfo.getMessage());
        LOG.error(message.toString(), ex);
        ExceptionResultVO result = ExceptionTransformer.transform(exceptionInfo, this.getErrorInfoFromException(ex));
        return result;
//        ex.printStackTrace();
//        System.out.println("输出结果异常编号:"+ex.getCode()+";异常描述："+ ex.getMsg());//输出结果
//        return ObjectToResult.getResult(ex.getCode(), ex.getMsg());
    }

    public String getErrorInfoFromException(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
        } catch (Exception var13) {
            LOG.error("getErrorInfoFromException occur exception.");
        } finally {
            try {
                if(null != sw) {
                    sw.close();
                }

                if(null != pw) {
                    pw.close();
                }
            } catch (IOException var12) {
                LOG.error("close fail.");
            }

        }

        return sw.toString();
    }

    private ExceptionInfo getExceptionInfo(String errorCode, Object[] args) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String errorCodeStr = "todoAPI.common.unchecked";
        String message = "System error.";
        String description = "";
        String tip = "";

        try {
            errorCodeStr = this.messageSource.getMessage(errorCode, (Object[])null, request.getLocale());
        } catch (NoSuchMessageException var12) {
            LOG.error("errorCode is not defined in exception_info_xxx.properties。", var12);
        }

        try {
            message = this.messageSource.getMessage(errorCodeStr + ".message", args, request.getLocale());
        } catch (NoSuchMessageException var11) {
            LOG.error("message is not defined in exception_info_xxx.properties。", var11);
        }

        try {
            description = this.messageSource.getMessage(errorCodeStr + ".description", (Object[])null, request.getLocale());
        } catch (NoSuchMessageException var10) {
            LOG.error("description is not defined in exception_info_xxx.properties。", var10);
        }

        try {
            tip = this.messageSource.getMessage(errorCodeStr + ".tip", (Object[])null, request.getLocale());
        } catch (NoSuchMessageException var9) {
            LOG.error("tip is not defined in exception_info_xxx.properties。", var9);
        }

        ExceptionInfo exceptionInfo = new ExceptionInfo(errorCode, message, description, tip);
        return exceptionInfo;
    }
}
