package cn.cjd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableHystrix
//@EnableHystrixDashboard
@ComponentScan({"cn.cjd.springboot.modal"})
@EnableCaching //开启缓存
@EnableTransactionManagement // 开启事务管理
@SpringBootApplication
//@ImportResource(locations = {"classpath:application-bean.xml"})
public class Application {

    public static void main( String[] args ){
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}

