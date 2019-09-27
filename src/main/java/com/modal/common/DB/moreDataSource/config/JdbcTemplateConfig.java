package com.modal.common.DB.moreDataSource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by 170096 on 2019/1/22 15:59
 *
 * @author ${User}
 */
@Configuration
public class JdbcTemplateConfig {

    /** 发布数据源 */
    @Bean(name = "otherJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("otherDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
