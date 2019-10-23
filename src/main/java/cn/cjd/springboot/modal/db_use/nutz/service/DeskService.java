package cn.cjd.springboot.modal.db_use.nutz.service;

import cn.cjd.springboot.modal.db_use.nutz.bean.Desk;
import cn.cjd.springboot.modal.db_use.nutz.nutzdao.service.BaseServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.nutz.dao.Dao;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeskService extends BaseServiceImpl<Desk> {

    public DeskService(Dao dao) {
        super(dao);
    }

    public void addDesk(Desk desk){
        this.insert(desk);
    }


    public static void main(String[] args) {
        String luru1 = "[{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568900000000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1568908800000,\"endChargTime\":1571414400000,\"renAmount\":0},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1571500800000,\"endChargTime\":1579363200000,\"renAmount\":3668},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1579449600000,\"endChargTime\":1587225600000,\"renAmount\":5502},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1587312000000,\"endChargTime\":1595088000000,\"renAmount\":5502},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1595174400000,\"endChargTime\":1603036800000,\"renAmount\":5498}]";
        String luru2 = "[{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1568908800000,\"endChargTime\":1571414400000,\"renAmount\":0},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1571500800000,\"endChargTime\":1579363200000,\"renAmount\":3668},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1579449600000,\"endChargTime\":1587225600000,\"renAmount\":5502},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1587312000000,\"endChargTime\":1595088000000,\"renAmount\":5502},{\"addType\":\"NOTRISE\",\"advanceDays\":5,\"chargType\":\"REN\",\"cycle\":3,\"rentalFreeStart\":1568908800000,\"rentalFreeEnd\":1571414400000,\"startChargTime\":1595174400000,\"endChargTime\":1603036800000,\"renAmount\":5498}]";
        JSONArray array1 = JSONArray.parseArray(luru1);
        JSONArray array2 = JSONArray.parseArray(luru2);

//        System.out.println("房东合同录入1录入的信息：");
//        printInfo(array1);
//        System.out.println("房东合同录入2录入的信息：");
//        printInfo(array2);

        compareTwoList(array1, array2);

    }

    private static void printInfo(JSONArray array) {
        for (Object o : array) {
            JSONObject jsonObject = JSONObject.parseObject(String.valueOf(o));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            System.out.println("费用类型：" + jsonObject.get("chargType") + " 金额：" +   jsonObject.get("renAmount") +
                    " 开始时间：" + sdf.format(Long.valueOf(String.valueOf(jsonObject.get("rentalFreeStart")))) +
                    " 结束时间：" + sdf.format(Long.valueOf(String.valueOf(jsonObject.get("rentalFreeEnd")))) +
                    " 提前付款天数：" + jsonObject.get("advanceDays"));
        }
    }

    public static void compareTwoList(JSONArray array1, JSONArray array2) {

        List<String> rentDetailDifferentIndexList = new ArrayList<>();

        System.out.println("codeList1: ");
        List<String> codeList1 = createCode(array1);
        System.out.println("codeList2: ");
        List<String> codeList2 = createCode(array2);
        for (int i = 0; i < codeList1.size(); i++) {
            if (codeList2.contains(codeList1.get(i)))
                continue;
            rentDetailDifferentIndexList.add(String.valueOf(i));
        }

        for (int i = 0; i < codeList2.size(); i++) {
            if (codeList1.contains(codeList2.get(i)))
                continue;
            rentDetailDifferentIndexList.add(String.valueOf(i));
        }

        System.out.println("differentIndexList : " + JSON.toJSONString(rentDetailDifferentIndexList));
    }

    /**
     * 将需要对比的数据生成code
     * code生成机制： 开始时间 + 结束时间 + 费用类型 + 金额 + 提前付款天数
     */
    public static List<String> createCode(JSONArray array){
        List<String> codeList = new ArrayList<>();
        for (Object o : array) {
            JSONObject jsonObject = JSONObject.parseObject(String.valueOf(o));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String code = "S" + sdf.format(Long.valueOf(String.valueOf(jsonObject.get("rentalFreeStart")))) +
                    "E" + sdf.format(Long.valueOf(String.valueOf(jsonObject.get("rentalFreeEnd")))) +
                    "C" + jsonObject.get("chargType") +
                    "A" + jsonObject.get("renAmount") +
                    "D" + jsonObject.get("advanceDays");
            codeList.add(code);
            System.out.println(code);
        }
        return codeList;
    }
}
