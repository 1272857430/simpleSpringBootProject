package cn.cjd.springboot.modal.common.utils.regexp;

import org.junit.Test;

public class GetChinese {

    @Test
    public void test1() {
        //匹配正则表达式表达式

        //要匹配的字符串
        String mStr = "?:？：";
        System.out.println("测试的字符串:"+mStr);
        //判断是否存在中文
        if(mStr.matches(".*[\\u4e00-\\u9fa5].*")){
            System.out.println("存在中文");
        }
    }
}
