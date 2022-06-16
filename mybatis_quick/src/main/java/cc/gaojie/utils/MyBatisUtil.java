package cc.gaojie.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/16 0:30
 * @since 1.8
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getFactory() {
        return factory;
    }

    private static SqlSession getSqlSession(boolean isAutoCommit) {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession(isAutoCommit);
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 手动事务管理
     **/
    public static SqlSession getSqlSession() {
        return getSqlSession(false);
    }

    /**
     * 自动事务提交
     **/
    public static <T extends Object> T getMapper(Class<T> c) {
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }

}