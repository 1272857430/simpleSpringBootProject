package cn.cjd.springboot.modal.common.result;

import java.util.List;

/**
 * Created by 170096 on 2018/8/29
 */
public class ObjectToResult {
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = 1;

    public ObjectToResult() {
    }

    public static Result getResult(Object object) {
        Result result = new Result();
        result.setResultCode(Integer.valueOf(0));
        result.setResultMsg("success");
        result.setTotalNum(Long.valueOf(1L));
        result.setIsPage(Boolean.valueOf(false));
        result.setData(object);
        return result;
    }

    public static Result getResult(int code, String msg) {
        Result result = new Result();
        result.setResultCode(Integer.valueOf(code));
        result.setResultMsg(msg);
        result.setTotalNum(Long.valueOf(1L));
        result.setIsPage(Boolean.valueOf(false));
        return result;
    }

    public static Result getResult(List<?> list) {
        Result result = new Result();
        result.setResultCode(Integer.valueOf(0));
        result.setResultMsg("success");
        result.setTotalNum(Long.valueOf(list != null?Long.valueOf((long)list.size()).longValue():0L));
        result.setIsPage(Boolean.valueOf(false));
        result.setData(list);
        return result;
    }

    public static Result getResult(Page page) {
        Result result = new Result();
        result.setResultCode(Integer.valueOf(0));
        result.setResultMsg("success");
        result.setTotalNum(page.getCount());
        result.setIsPage(Boolean.valueOf(true));
        result.setTotalPage(page.getMaxPage());
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setData(page.getObjList());
        return result;
    }

    public static Result getResult(Exception ex) {
        Result result = new Result();
        result.setResultCode(Integer.valueOf(1));
        result.setResultMsg(ex.getMessage());
        return result;
    }
}
