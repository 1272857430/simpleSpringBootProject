package cn.cjd.springboot.modal.testModal.testDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by 170096 on 2018/8/9
 */
@RunWith(SpringJUnit4ClassRunner.class)//让测试运行于spring测试环境
@WebAppConfiguration
//@ContextConfiguration({"classpath*:spring-hibernate.xml"})//指定 Spring 配置文件所在的位置
public class junitTest {

    @Before
    public void getUser(){
        System.out.println("Before");
    }

    @After
    public void print(){
        System.out.println("After");
    }

    @Test
    public void save(){
        System.out.println("Test");
    }

}
