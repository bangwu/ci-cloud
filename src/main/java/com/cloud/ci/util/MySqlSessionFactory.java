package com.cloud.ci.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MySqlSessionFactory {
    private static SqlSessionFactory factory;
    private MySqlSessionFactory() {
    }

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }
}
