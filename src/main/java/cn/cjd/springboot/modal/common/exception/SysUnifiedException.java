package cn.cjd.springboot.modal.common.exception;

/**
 * Created by 170092 on 2017/8/进程与线程.txt
 */
public class SysUnifiedException extends RuntimeException{
    private static final long serialVersionUID = 5473207250468399417L;
    private String errorCode;
    private Object[] args;

    public SysUnifiedException() {
    }

    public SysUnifiedException(String errorCode) {
        this.errorCode = errorCode;
    }

    public SysUnifiedException(String errorCode, Object[] args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public SysUnifiedException(Throwable ex, String errorCode) {
        super(ex);
        this.errorCode = errorCode;
    }

    public SysUnifiedException(Throwable ex, String errorCode, Object[] args) {
        super(ex);
        this.errorCode = errorCode;
        this.args = args;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object[] getArgs() {
        return this.args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
