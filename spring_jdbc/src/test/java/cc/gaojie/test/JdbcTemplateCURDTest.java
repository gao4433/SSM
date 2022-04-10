package cc.gaojie.test;

import cc.gaojie.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description JdbcTemplate 常用操作
 * @date 2022/4/10 12:42
 * @since 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)   //指定由谁执行
@ContextConfiguration("classpath:applicationContext.xml")   //指定配置文件
public class JdbcTemplateCURDTest {

    @Autowired    //让Spring注入
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        int row = jdbcTemplate.update("update account set money = ? where name = ?", 10000, "gaojie");
        System.out.println("影响行数：" + row);
    }

    @Test
    public void testDelete() {
        int row = jdbcTemplate.update("delete from account where name = ?", "lisa");
        System.out.println("影响行数：" + row);
    }

    @Test
    public void testQueryAll() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testQueryOne() {
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(account);;
    }

    @Test
    public void testQueryCount() {
        Long account = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(account);
    }
}
