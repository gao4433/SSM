package cc.gaojie.service.impl;

import cc.gaojie.dao.RoleDao;
import cc.gaojie.dao.UserDao;
import cc.gaojie.domain.Role;
import cc.gaojie.domain.User;
import cc.gaojie.service.UserService;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/12 11:15
 * @since 1.8
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {

        List<User> userList = userDao.findAll();

        //封装userList中每一个user的role数据
        for (User user: userList) {
            //获得User到id
            Long id = user.getId();
            //将id作为参数，查询当前userId对应的Role集合数据
            List<Role> roleList = roleDao.findByUserId(id);
            user.setRoles(roleList);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //向sys_user表中存储数据
        Long userId = userDao.save(user);
        //向sys_user_role表中存储多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }
}
