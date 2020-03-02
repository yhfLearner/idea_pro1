package com.hwua.util;/*
package com.hwua.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Properties;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sessionFactory = null;
    private static SqlSessionFactory getSqlSessionFactory() {
        if (sessionFactory == null) {
            synchronized (SqlSessionFactoryUtil.class) {
                if (sessionFactory == null) {
                    try {
                        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sessionFactory;
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
}
*/
