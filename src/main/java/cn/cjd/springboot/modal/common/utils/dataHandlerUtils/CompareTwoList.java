package cn.cjd.springboot.modal.common.utils.dataHandlerUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CompareTwoList {

    /**
     * 对比两个JSONARRAY 是否一致
     * 对比思想：一条数据根据一定的规则生成一个对比的code，然后交叉验证
     */
    public void CompareTwoArray(JSONArray array1, JSONArray array2){
        List<String> codeList1 = createCodeList(array1);
        List<String> codeList2 = createCodeList(array2);
    }

    /**
     * 按照一定的规则将JSONARRAY 生成 List<String>
     */
    private List<String> createCodeList(JSONArray array) {
        List<String> codeList = new ArrayList<>();
        for (Object o : array) {
            JSONObject jsonObject = JSONObject.parseObject(String.valueOf(o));
            // 按照一定的规则生成code
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String code = "S" + sdf.format(Long.valueOf(String.valueOf(jsonObject.get("rentalFreeStart")))) +
                    "E" + sdf.format(Long.valueOf(String.valueOf(jsonObject.get("rentalFreeEnd")))) +
                    "C" + jsonObject.get("chargType") +
                    "A" + jsonObject.get("renAmount") +
                    "D" + jsonObject.get("advanceDays");
            codeList.add(code);
        }
        return codeList;
    }
}
