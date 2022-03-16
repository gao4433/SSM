package cc.gaojie.service.impl;

import cc.gaojie.dao.UserDao;
import cc.gaojie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/16 15:38
 * @since 1.8
 */
/*<bean id="userService" class="cc.gaojie.service.impl.UserServiceImpl">*/
//@Component("userService")
@Service("userService")
@Scope("singleton")   //标注bean的作用范围
public class UserServiceImpl implements UserService {

    //注入普通属性
    //@Value("com.mysql.jdbc.Driver") //等同于直接赋值
    @Value("${jdbc.driver}")  //匹配配置文件中的键4的值
    private String driver;

    //<property name="userDao" ref="userDao"></property>
    @Autowired //按数据类型从Spring容器中进行匹配，但容器有多个UserDao类型bean会报错
    @Qualifier("userDao") //按照 id 的值从Spring容器中匹配，必须结合@Autowired使用
    //@Resource(name = "userDao") //相当于 @Qualifier+@Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
        System.out.println(driver);
    }

    @PostConstruct   //标注bean的初始化方法（构造之后）
    public void init() {
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy //标注bean的销毁方法
    public void destroy() {
        System.out.println("Service对象的销毁方法");
    }
}
