package com.modal.common.DB.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 170096 on 2018/5/24
 */

public class DBAccess {

    /**
     * 获取连接session
     *
     */
    public SqlSession getSqlSession() throws IOException {

        // 通过配置文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("com/modal/common/DB/mybatis/config/Configuration.xml");
        // 通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 通过sqlSessionFactory打开一个数据库会话
        return sqlSessionFactory.openSession();
    }
}
