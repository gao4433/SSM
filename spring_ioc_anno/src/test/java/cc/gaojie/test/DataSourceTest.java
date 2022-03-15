package cc.gaojie.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 数据源（连接池测试）
 * @date 2022/3/15 14:46
 * @since 1.8
 */
public class DataSourceTest {

    @Test
    //测试 Spring 容器产生数据源对象
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }


    @Test
    //测试手动创建 c3p0 数据源
    public void test01() throws Exception {
        //创建数据源实例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        //设置数据源连接参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("778874315");

        //获取数据源资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试手动创建 druid数据源
    public void test02() throws Exception {
        //创建数据源实例
        DruidDataSource dataSource = new DruidDataSource();

        //设置数据源连接参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("778874315");

        //获取数据源资源
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    //测试手动创建 c3p0 数据源（加载 properties 配置文件）
    public void test03() throws Exception {
        //读取配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String username = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");

        //创建数据源实例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据源连接参数
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        //获取数据源资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
