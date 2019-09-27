package cn.cjd.springboot.modal.common.restTemplate;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class RestTemplateUtils {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateUtils.class);

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateUtils(@Qualifier("mdmRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     *
     * @param url       地址
     * @param method    方式
     * @param object    内容
     */
    public Object restTemplete(String url, String method, Object object) {
        logger.info("url: " + url);
        logger.info("method: " + method);
        logger.info("data: " + JSON.toJSONString(object));
        if (Methods.POST.getCode().equals(method)) {
            return this.post(url, object);
        } else if (Methods.GET.getCode().equals(method)) {
            return this.get(url);
        } else {
            return null;
        }
    }

    /**
     * POST 请求
     */
    private Object post(String url, Object object) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.toString());
        HttpEntity<Object> requestEntity = new HttpEntity<>(object, headers);

        return restTemplate.postForObject(url, requestEntity, object.getClass());
    }

    /**
     * Get请求
     */
    private Object get(String url) {

        return restTemplate.getForObject(url, Object.class);
    }
}
