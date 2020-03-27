package cn.cjd.springboot.modal.thread.futureTask.simpleUse;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.Callable;

public class MainTask implements Callable<FormReportBean> {

    private Long flowTaskId;

    public MainTask(Long flowTaskId) {
        this.flowTaskId = flowTaskId;
    }

    @Override
    public FormReportBean call() throws Exception {
        FormReportBean formReportBean = new FormReportBean();
        //直接查询结果表
        FormExcelResult formExcelResult = formExcelResultProvider.queryByTaskId(flowTaskId);
        //如果结果表中有数据，
        if (formExcelResult != null) {
            //将json转为对象
            formReportBean = JSONObject.parseObject(formExcelResult.getResult(), FormReportBean.class);

        } else {//否则，查询对应的表组装数据
            formReportBean = getFormRecordsByTaskClassify(flowTaskId);
            if (formReportBean == null)
                return null;

            FormExcelResult record = new FormExcelResult();
//                record.setOrgId(formReportBean.getOrgId());
//                record.setFlowTaskId(formReportBean.getTaskId());
//                record.setResult(JSON.toJSONString(formReportBean));
//                record.setPlanTime(formReportBean.getPlanTime());
//                record.setCreateBy(1L);
//                record.setUpdateBy(1L);
            formExcelResultProvider.update(record);
        }


        getReviewRecordForExcel(formReportBean);

        return formReportBean;
    }


    /**
     * 以下是为了不报错写的
     */
    private static FormExcelResultProvider formExcelResultProvider = new FormExcelResultProvider();

    private FormReportBean getFormRecordsByTaskClassify(Long flowTaskId) {
        return new FormReportBean();
    }

    private void getReviewRecordForExcel(FormReportBean formReportBean) {
    }

}
