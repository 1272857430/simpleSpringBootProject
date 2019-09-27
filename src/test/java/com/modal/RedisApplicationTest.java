package com.modal;

import com.modal.common.utils.simpleUtils.GsonUtil;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
@Transactional //打开的话测试之后数据可自动回滚
@Rollback(false)
public class RedisApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void setUp()   {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * get 请求方式测试
     */
    protected String buildGetReq(String path,MultiValueMap<String, String> params) throws Exception{
        if (params==null){
            return mockMvc.perform(MockMvcRequestBuilders.get(path)).andReturn().getResponse().getContentAsString();
        }else{
            return mockMvc.perform(MockMvcRequestBuilders.get(path).params(params)).andReturn().getResponse().getContentAsString();
        }
    }

    /**
     * post 请求方式测试
     */
    protected String buildPostReq(String path, String json) throws Exception{
        String result = null;
        if (json==null){
            result = mockMvc.perform(MockMvcRequestBuilders.post(path)).andReturn().getResponse().getContentAsString();
        }else{
            result = mockMvc.perform(MockMvcRequestBuilders.post(path).contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andReturn().getResponse().getContentAsString();
        }
        String resultCode =  GsonUtil.gsonToMaps(result).get("resultCode").toString();
        if (resultCode.equals("进程与线程.txt")) {
            throw new RuntimeException(GsonUtil.gsonToMaps(result).get("resultMsg").toString());
        }
        return result;
    }
    protected String buildPostReq(String path,MultiValueMap<String, String> params) throws Exception{
        if (params==null){
            return mockMvc.perform(MockMvcRequestBuilders.post(path)).andReturn().getResponse().getContentAsString();
        }else{
            return mockMvc.perform(MockMvcRequestBuilders.post(path).params(params)).andReturn().getResponse().getContentAsString();
        }
    }

    /**
     * put 请求方式测试
     */
    protected String buildPutReq(String path, String json) throws Exception{
        String result = null;
        if (json == null) {
            result = mockMvc.perform(MockMvcRequestBuilders.put(path)).andReturn().getResponse().getContentAsString();
        } else {
            result = mockMvc.perform(MockMvcRequestBuilders.put(path).contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andReturn().getResponse().getContentAsString();
        }
        String resultCode =  GsonUtil.gsonToMaps(result).get("resultCode").toString();
        if (resultCode.equals("进程与线程.txt")) {
            throw new RuntimeException(GsonUtil.gsonToMaps(result).get("resultMsg").toString());
        }
        return result;

    }

    /**
     * Delete 请求方式测试
     */
    protected String buildDelReq(String path,MultiValueMap<String, String> params) throws Exception{
        if (params==null){
            return mockMvc.perform(MockMvcRequestBuilders.delete(path)).andReturn().getResponse().getContentAsString();
        }else{
            return mockMvc.perform(MockMvcRequestBuilders.delete(path).params(params)).andReturn().getResponse().getContentAsString();
        }
    }
}