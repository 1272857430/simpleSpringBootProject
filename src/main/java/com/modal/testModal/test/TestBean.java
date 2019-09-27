package com.modal.testModal.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class TestBean {

    @Value("${spring.redis.host}")
    private static String host;

    @Value("${spring.redis.port}")
    private static int port;

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        TestBean.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        TestBean.port = port;
    }

}
