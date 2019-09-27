package com.modal.common.restTemplate;

import org.springframework.aop.framework.ProxyConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriTemplateHandler;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
@ConditionalOnClass(ProxyConfig.class)
public class RestConfig {

    @Value("${rest.ReadTimeout}")
    private int readTimeout;

    @Value("${rest.ConnectTimeout}")
    private int connectionTimeout;

    @Bean({"mdmRestTemplate"})
    public RestTemplate mdmRestTemplate() {
        return this.restTemplate();
    }

    private RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(readTimeout);
        factory.setReadTimeout(connectionTimeout);
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setUriTemplateHandler(this.uriTemplateHandler());
        return restTemplate;
    }

    private UriTemplateHandler uriTemplateHandler() {
        DefaultUriTemplateHandler uriTemplateHandler = new DefaultUriTemplateHandler();
        uriTemplateHandler.setStrictEncoding(true);
        return uriTemplateHandler;
    }
}
