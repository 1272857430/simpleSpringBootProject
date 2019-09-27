package cn.cjd.springboot.modal.common.DB.moreDataSource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by 170096 on 2019/1/22 15:55
 *
 * @author ${User}
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "otherDataSource")
    @Qualifier("otherDataSource")
    @ConfigurationProperties(prefix="spring.datasource.other")
    public DataSource truckOneDataSource() {
        return DataSourceBuilder.create().build();
    }
}
