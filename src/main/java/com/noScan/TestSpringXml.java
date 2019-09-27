package com.noScan;

import org.hibernate.cfg.Configuration;

/**
 * 测试Spring 注入
 * Created by 170096 on 2018/9/11.
 */
public class TestSpringXml {
    public TestSpringXml() {
        System.out.println("这是一个不在 spring boot 扫描范围内的测试类");
    }

    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
    }
}
