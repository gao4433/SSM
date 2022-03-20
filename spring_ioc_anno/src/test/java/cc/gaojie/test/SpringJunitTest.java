package cc.gaojie.test;

import cc.gaojie.config.SpringConfiguration;
import cc.gaojie.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author gaojie  gao4433@qq.com
 * @Description Spring集成Junit开发
 * @date 2022/3/16 19:58
 * @since 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)   //指定运行内核
//@ContextConfiguration("classpath:applicationContext.xml")    //指定核心配置文件
@ContextConfiguration(classes = {SpringConfiguration.class})   //指定核心配置类
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() throws SQLException {
        userService.save();
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
