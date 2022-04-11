package cc.gaojie.service.impl;

import cc.gaojie.dao.RoleDao;
import cc.gaojie.domain.Role;
import cc.gaojie.service.RoleService;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/10 19:38
 * @since 1.8
 */
public class RoleServiceImpl implements RoleService {

    /**
     * 注入roleDao对象
     */
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
      List<Role>  roleList = roleDao.findAll();
      return roleList;
    }
}
