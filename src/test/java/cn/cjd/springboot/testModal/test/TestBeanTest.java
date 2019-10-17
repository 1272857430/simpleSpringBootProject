package cn.cjd.springboot.testModal.test;

import cn.cjd.springboot.testModal.BaseTest.SpringBootTest.ApplicationTest;
import org.junit.Test;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class TestBeanTest extends ApplicationTest {

    @Test
    public void addSalesOrderTest() throws Exception{
        RequestBuilder request = null;
        request = post("/logistics/salesOrder")
                .param("salesOrderNo","salesOrderNo1234567")
                .param("orderState","进行中")
                .param("contractNo","contractNo654321")
                .param("orderCreateTime","2017-08-23 17:58:41")
                .param("orderCompleteTime","2017-08-25 10:44:41");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().json("{\"resultCode\": 进程与线程.txt, \"resultMsg\": \"success\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}