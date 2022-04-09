package cc.gaojie.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 测试类
 * @date 2022/4/10 0:21
 * @since 1.8
 */
public class JdbcTemplateTest {

    /**
     * 测试JdbcTemplate开发步骤
     */
    @Test
    public void test() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("778874315");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象，知道数据库在哪里
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)", "tom", 5000);
        System.out.println("影响行数：" + row);
    }

    /**
     * 测试Spring产生JdbcTemplate对象
     */
    @Test
    public void test2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?,?)", "lisa", 3000);
        System.out.println("影响行数：" + row);
    }
}
