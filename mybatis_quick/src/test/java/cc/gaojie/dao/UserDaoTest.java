package cc.gaojie.dao;

import cc.gaojie.domain.User;
import cc.gaojie.utils.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
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
            assertEquals(1, i);
            ////释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void testDeleteUser() {
        UserDao userDao = MyBatisUtil.getMapper(UserDao.class);
        int i = userDao.deleteUser(1021);
    }


    public void testUpdateUser() {
        //获取会话sqlSession
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //通过会话获取DAO对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //测试StudentDAO中的方法
        int i = userDao.updateUser(new User(0, "王武", "123"));
        //需要手动提交
        sqlSession.commit();
        //断言
        assertEquals(1, i);
    }

    public void testListUsers() {
        //通过会话获取DAO对象
        UserDao userDao = MyBatisUtil.getMapper(UserDao.class);
        //测试StudentDAO中的方法
        List<User> users = userDao.listUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void testQueryUser() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactorryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            ////通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //测试StudentDAO中的方法
            User user = userDao.queryUser(0);
            System.out.println(user);
            ////释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testListUserByPage1() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            //通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //测试StudentDAO中的方法
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("start", 0);
            map.put("pageSize", 2);
            List<User> users = userDao.listUserByPage1(map);
            for (User user : users) {
                System.out.println(user);
            }
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testListUserByPage2() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            //通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //测试StudentDAO中的方法
            List<User> users = userDao.listUserByPage2(0, 2);
            for (User user : users) {
                System.out.println(user);
            }
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testListUserByPage3() {
        try {
            //加载mybatis配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //获取session工厂对象
            SqlSessionFactory factory = builder.build(is);
            //获取session对象
            SqlSession sqlSession = factory.openSession();
            //通过会话获取DAO对象
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            //测试StudentDAO中的方法
            List<User> users = userDao.listUserByPage3(0, 2);
            for (User user : users) {
                System.out.println(user);
            }
            //释放资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testGetCount() {
        //通过会话获取DAO对象
        UserDao userDao = MyBatisUtil.getMapper(UserDao.class);
        //测试StudentDAO中的方法
        int count = userDao.getCount();
        System.out.println(count);
    }


    public void testTestPagePlugins() {
        UserDao userDao = MyBatisUtil.getMapper(UserDao.class);

        //设置查询第二页的数据，每页4行数据
        PageHelper.startPage(1, 2);

        List<User> users = userDao.listUsers();

        //pageInfo中就包含了数据及分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(users);

        List<User> list = pageInfo.getList();
        for (User user : users) {
            System.out.println(user);
        }

    }
}