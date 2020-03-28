package cn.cjd.springboot.modal.thread.futureTask.simpleUse;

import cn.cjd.springboot.modal.thread.pool.ThreadPoolUtil;

import java.util.*;
import java.util.concurrent.FutureTask;


public class MainClass {

    public List<FormReportBean> getFormRecordsByTaskClassify(Map<String, Object> map) {
//        Long start = System.currentTimeMillis();
        List<FormReportBean> result = InstanceUtil.newArrayList();
        //根据条件查询出所有符合条件的flow_task
        List<Long> flowTaskIds = flowTaskProvider.getFlowTaskIdsByMap(map);
        if (flowTaskIds == null || flowTaskIds.size() == 0)
            return null;

        List<FutureTask<FormReportBean>> futureTaskList = new ArrayList<>();
        // 创建任务队列
        flowTaskIds.forEach(taskId -> {
            MainTask mainTask = new MainTask(taskId);
            FutureTask<FormReportBean> futureTask = new FutureTask<>(mainTask);
            futureTaskList.add(futureTask);
        });
        // 启动任务
        futureTaskList.parallelStream().forEach(futureTask -> {
            if (futureTask != null)
                ThreadPoolUtil.getExecutorService().execute(futureTask);
        });

        // 获取处理结果
        futureTaskList.parallelStream().forEach(futureTask-> {
            try {
                FormReportBean formReportBean = futureTask.get();
                if (formReportBean != null)
                    result.add(formReportBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        result.stream().sorted(Comparator.comparing(FormReportBean::getPlanTime));

//        logger.info("总耗时==========================" + ((System.currentTimeMillis() - start) / 1000));
        return result;
    }


    /**
     * 以下是为了不报错写的
     */
    private static FowTaskProvider flowTaskProvider = new FowTaskProvider();

}


/**
 * 以下是为了不报错写的
 */
class FormExcelResultProvider {

    public FormExcelResult queryByTaskId(Long flowTaskId) {
        return new FormExcelResult();
    }

    public void update(FormExcelResult record) {
    }
}

class FowTaskProvider {

    public List<Long> getFlowTaskIdsByMap(Map<String, Object> map) {
        return new ArrayList<>();
    }
}

class FormReportBean{

    public Long getPlanTime(){
        return new Date().getTime();
    }

}

class FormExcelResult {

    public String getResult() {
        return "";
    }

    public void setCreateBy(long l) {
    }
}

class InstanceUtil{

    public static List<FormReportBean> newArrayList() {
        return new ArrayList<>();
    }
}