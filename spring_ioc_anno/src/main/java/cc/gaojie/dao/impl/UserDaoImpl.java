package cc.gaojie.dao.impl;

import cc.gaojie.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/16 15:36
 * @since 1.8
 */
/*<bean id="userDao" class="cc.gaojie.dao.impl.UserDaoImpl" ></bean>*/
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("sava running…………");
    }
}
