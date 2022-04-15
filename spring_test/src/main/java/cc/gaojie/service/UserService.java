package cc.gaojie.service;

import cc.gaojie.domain.User;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/12 11:14
 * @since 1.8
 */
public interface UserService {

    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);
}
