package cn.cjd.springboot;

import cn.cjd.springboot.modal.common.utils.springContext.SpringContextUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableHystrix
//@EnableHystrixDashboard
@ComponentScan({"cn.cjd.springboot.modal"})
@EnableCaching //开启缓存
@EnableTransactionManagement // 开启事务管理
@SpringBootApplication
@ImportResource(locations = {"classpath:application-bean.xml"})
public class Application {

    public static void main( String[] args ){
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }

    @Bean("defaultStart")
    public CommandLineRunner defaultStart() {
        return (String... strings) -> {
            System.out.println("项目启动完毕，初始化执行的方法");
        };
    }
}

