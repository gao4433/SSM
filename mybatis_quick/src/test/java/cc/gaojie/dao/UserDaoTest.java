package cc.gaojie.dao;

import cc.gaojie.domain.User;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserDaoTest extends TestCase {

    public void testInsertUser() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            ////通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            ////测试StudentDAO中的方法
            int i = userDao.insertUser(new User(1002, "李斯", "123"));
            ////需要手动提交
            sqlSession.commit();
            //断言
            assertEquals(1,i);
            ////释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void testDeleteUser() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            ////通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            ////测试StudentDAO中的方法
            int i = userDao.deleteUser(1021);
            ////需要手动提交
            sqlSession.commit();
            //断言
            assertEquals(1,i);
            ////释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void testUpdateUser() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            ////通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            ////测试StudentDAO中的方法
            int i = userDao.updateUser(new User(0,"王武","123"));
            ////需要手动提交
            sqlSession.commit();
            //断言
            assertEquals(1,i);
            ////释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testListUsers() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            ////通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //测试StudentDAO中的方法
            List<User> users = userDao.listUsers();
            for (User user:users ) {
                System.out.println(user);
            }
            ////需要手动提交
            sqlSession.commit();
            //断言
            assertNotNull(users);
            ////释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}