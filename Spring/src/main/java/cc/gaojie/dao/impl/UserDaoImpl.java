package cc.gaojie.dao.impl;

import cc.gaojie.dao.UserDao;

/**
 * @author gaojie  gao4433@qq.com
 * @Description UserDao接口实现类
 * @date 2022/3/12 17:56
 * @since 1.8
 */
public class UserDaoImpl implements UserDao {

    /**
     * 无参构造
     */
    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建…………");
    }

    @Override
    public void save() {
        System.out.println("save running…………");
    }

    public void init() {
        System.out.println("初始化方法…………");
    }

    public void destroy() {
        System.out.println("销毁方法…………");
    }
}
