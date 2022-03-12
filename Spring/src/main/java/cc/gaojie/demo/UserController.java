package cc.gaojie.demo;

import cc.gaojie.service.UserService;
import cc.gaojie.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/13 0:35
 * @since 1.8
 */
public class UserController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }

}
