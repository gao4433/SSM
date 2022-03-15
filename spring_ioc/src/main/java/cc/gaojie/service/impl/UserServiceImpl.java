package cc.gaojie.service.impl;

import cc.gaojie.dao.UserDao;
import cc.gaojie.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/13 0:30
 * @since 1.8
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void save() {
        userDao.save();
    }
}
