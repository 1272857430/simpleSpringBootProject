package com.modal;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class DemoCtrlTest extends RedisApplicationTest {
    
    @Test
    public  void testDemoGet() throws  Exception{

        System.out.println("buildGetReq(\"/demo\",null) = " + buildGetReq("/demo",null));
    }

    @Test
    public  void testDemoGetID() throws  Exception{
        System.out.println("buildGetReq(\"/demo\",null) = " + buildGetReq("/demo/5",null));
    }

    @Test
    public  void testDemoGetPage() throws  Exception{
        MultiValueMap<String, String>  params = new LinkedMultiValueMap<String, String>();
        params.add("page","进程与线程.txt");
        params.add("rows","2");
        System.out.println("buildGetReq(\"/demo\",null) = " + buildGetReq("/demo",params));
    }

    @Test
    public  void testDemoPostAdd() throws  Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("firstName","firstName1");
        params.add("lastName","lastName2");
        params.add("age","13");
        params.add("gender","changsha");
        params.add("sno","003");
        System.out.println("buildGetReq(\"/demo\",null) = " + buildPostReq("/demo",params));
    }

    @Test
    public  void testDemoPostUpdate() throws  Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("firstName","firstName1");
        params.add("lastName","lastName2");
        params.add("age","26");
        params.add("gender","changsha");
        params.add("sno","26");
        params.add("id","26");
        System.out.println("buildGetReq(\"/demo\",null) = " + buildPostReq("/demo",params));
    }

    @Test
    public  void testDemoDeleteByID() throws  Exception{
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("firstName","firstName1");
//        params.add("lastName","lastName2");
//        params.add("age","26");
//        params.add("gender","changsha");
//        params.add("sno","26");
//        params.add("id","26");
        System.out.println("buildGetReq(\"/demo\",null) = " + buildDelReq("/demo/26",null));
    }

    @Test
    public  void testDemoDeleteByIDs() throws  Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("ids","22,23,24");
        System.out.println("buildGetReq(\"/demo\",null) = " + buildDelReq("/demo",params));
    }

    @Test
    public  void testDemoGetSearchCondStrs() throws  Exception{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("searchCondStrs","firstName_op_2222|gender_eq_2222"); //|gender_eq_2222
        System.out.println("buildGetReq(\"/demo\",null) = " + buildGetReq("/demo",params));
    }

}
