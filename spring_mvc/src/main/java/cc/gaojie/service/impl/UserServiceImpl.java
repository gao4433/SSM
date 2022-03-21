package cc.gaojie.service.impl;

import cc.gaojie.dao.UserDao;
import cc.gaojie.service.UserService;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/20 19:06
 * @since 1.8
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void save() {
        userDao.save();
    }
}
