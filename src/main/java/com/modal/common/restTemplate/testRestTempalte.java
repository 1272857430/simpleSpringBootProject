package com.modal.common.restTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mdm/test")
public class testRestTempalte {

    private final RestTemplateUtils restTemplateUtils;

    @Autowired
    public testRestTempalte(RestTemplateUtils restTemplateUtils) {
        this.restTemplateUtils = restTemplateUtils;
    }

    @GetMapping(value = "/testSender")
    public Object testSender(){
        String url = "http://127.0.0.进程与线程.txt/mdm/test/testReceive";
        JSON json = new JSONObject();
        return restTemplateUtils.restTemplete(url, Methods.GET.getCode(), json);
    }

    @GetMapping(value = "/testReceive")
    public Object testReceive(){
        return "hahha";
    }


    @PostMapping(value = "/receiveGoods")
    public Object receiveGoods (@RequestBody Object object) {
        System.out.println(JSON.toJSONString(object));
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(object));
        JSONArray jsonArray = jsonObject.getJSONArray("dataInfo");
        for (int i=0; i<jsonArray.size(); i++) {
            JSONObject jObject = jsonArray.getJSONObject(i);
            jObject.put("resultCode","0");
            jObject.put("resultMsg","SUCCESS");
        }
        JSONObject returnObject = new JSONObject();
        returnObject.put("resultCode","0");
        returnObject.put("resultMsg","SUCCESS");
        returnObject.put("uuid", jsonObject.get("uuid"));
        returnObject.put("dataInfo", jsonArray);
        System.out.println(JSON.toJSONString(returnObject));
        return returnObject;
    }
}
