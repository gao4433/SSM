import cc.gaojie.dao.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/12 23:03
 * @since 1.8
 */
public class SpringTest {

    /**
     * 测试scope属性
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
        //app.close();
    }
}
