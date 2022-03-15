package cc.gaojie.factory;

import cc.gaojie.dao.UserDao;
import cc.gaojie.dao.impl.UserDaoImpl;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 工厂静态方法实例化
 * @date 2022/3/12 23:57
 * @since 1.8
 */
public class StaticFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
