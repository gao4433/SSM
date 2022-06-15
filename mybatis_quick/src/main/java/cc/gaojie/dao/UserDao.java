package cc.gaojie.dao;

import cc.gaojie.domain.User;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/15 14:51
 * @since 1.8
 */
public interface UserDao {
    public  int insertUser(User user);
    public  int deleteUser(int id);
    public  int updateUser(User user);
    public  List<User> listUsers();
}
