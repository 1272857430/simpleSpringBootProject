package cn.cjd.springboot.modal.testModal.test;

import lombok.Getter;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * 中央空调项目枚举
 *
 * @author Created by xl.jia on 2018/06/06.
 */
@Getter
public enum AirConditionerBrandEnum {

    HAPPYCITY("永乐城"),

    OWBUILDING("欧文大厦"),

    RFBUILDING("瑞孚大厦"),

    HQBUILDING("东站恒祺");

    private String note;

    AirConditionerBrandEnum(String note) {
        this.note = note;
    }


    public final static List<String> ruifuBrandList;

    static {
        ruifuBrandList = new ArrayList<String>(){{
            // 瑞孚
            add(AirConditionerBrandEnum.RFBUILDING.name());
            // 东站
            add(AirConditionerBrandEnum.HQBUILDING.name());
        }};

    }

    public static void main(String[] args) {
        String sn = MD5("A606BBCD9EDA4B2EB21C888F4D681286HQBUILDINGA606BBCD9EDA4B2EB21C888F4D681286");
        System.out.println(sn);
    }

    /**
     * MD5加密
     * @param sourceStr
     * @return
     */
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
