package cc.gaojie.web;

import cc.gaojie.config.SpringConfiguration;
import cc.gaojie.service.UserService;
import cc.gaojie.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/16 15:45
 * @since 1.8
 */
public class UserController {

    public static void main(String[] args) {
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();

    }
}
