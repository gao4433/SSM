package cc.gaojie.factory;

import cc.gaojie.dao.UserDao;
import cc.gaojie.dao.impl.UserDaoImpl;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 工厂实例方法实例化
 * @date 2022/3/13 0:20
 * @since 1.8
 */
public class DynamicFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
