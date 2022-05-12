package cc.gaojie.test;

import cc.gaojie.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/5/7 4:25
 * @since 1.8
 */
public class MyBatisTest {

    /**
     * 查询操作
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作   参数：namespace.id
        List<Object> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    /**
     * 插入操作
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUsername("lisa");
        user.setPassword("abc");

        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作   参数：namespace.id
        sqlSession.insert("userMapper.save",user);

        //提交事务   （MyBatis默认事务是不提交的）
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    /**
     * 修改操作
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        //模拟user对象
        User user = new User();
        user.setId(57);
        user.setUsername("gaojie");
        user.setPassword("cc");

        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作   参数：namespace.id
        sqlSession.update("userMapper.modify",user);

        //提交事务   （MyBatis默认事务是不提交的）
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    /**
     * 删除操作
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {

        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作   参数：namespace.id
        sqlSession.delete("userMapper.delete",56);

        //提交事务   （MyBatis默认事务是不提交的）
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    /**
     * 条件查询操作
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {

        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行操作   参数：namespace.id
        List<Object> gaojie = sqlSession.selectList("userMapper.selectByName", "gaojie");
        //打印结果
        System.out.println(gaojie);

        //释放资源
        sqlSession.close();
    }
}
