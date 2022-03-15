package cc.gaojie.demo;

import cc.gaojie.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/12 18:17
 * @since 1.8
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        //加载Spring核心文件
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
