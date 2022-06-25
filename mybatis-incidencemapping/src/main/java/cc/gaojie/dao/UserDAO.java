package cc.gaojie.dao;

import cc.gaojie.pojo.User;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/23 20:08
 * @since 1.8
 */
public interface UserDAO {
    public int insertUser(User user);
    public User queryUser(String username);
}
