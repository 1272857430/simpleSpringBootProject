package cn.cjd.springboot.testModal.BaseTest.todoAPI;
/**
 * User: heibao
 * <p>
 * History:
 * 0.1, 2017/10/23, Initial version
 */

import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.junit.Assert;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

public class BaseTestCase extends Assert {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTestCase.class);

    private final static Mode mode = Mode.PRD;

    // 这个Object 指的是feign发现其他服务的api
    public Object payOrderApi;

    @Before
    public void setUp() {
        payOrderApi = todo(Object.class, mode.getNotifyUrl());
        payOrderApi = todo(Object.class, mode.getPayApiUrl());
    }

    public <T> T todo(Class<T> clazz, String serverUrl){
        SpringMvcContract contract = new SpringMvcContract();
        Feign.Builder builder = Feign.builder()
                .contract(contract)
                .decoder(new JacksonDecoder())
                .encoder(new FeignSpringFormEncoder());
        return builder.target(clazz, serverUrl);
    }
}
