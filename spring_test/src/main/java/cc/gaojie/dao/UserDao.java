package cc.gaojie.dao;

import cc.gaojie.domain.User;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/12 11:21
 * @since 1.8
 */
public interface UserDao {

    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);

    User findByUsernameAndPassword(String username, String password);
}
