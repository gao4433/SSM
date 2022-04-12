package cc.gaojie.dao;

import cc.gaojie.domain.Role;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/10 19:47
 * @since 1.8
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findByUserId(Long id);
}
