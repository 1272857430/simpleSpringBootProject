package com.modal.common.DB.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by 170096 on 2019/1/3 14:20
 *
 * @author ${User}
 */
public class HibernateUitl {

    private static SessionFactory sessionFactory;
    private static Session session;

    static {
        // 创建COnfiguration对象，读取hibernate.cfg.xml文件，完成初始化（默认读取hibernate.cfg.xml）
        Configuration cfg = new Configuration().configure("spring-hibernate.xml");
        // 创建服务注册对象
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        StandardServiceRegistry ssr = ssrb.build();
        // 创建会话工厂
        sessionFactory = cfg.buildSessionFactory(ssr);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public static void closeSeesion(Session session) {
        if (session != null) {
            session.close();
        }
    }
}
