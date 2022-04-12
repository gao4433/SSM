package cc.gaojie.dao.impl;

import cc.gaojie.dao.RoleDao;
import cc.gaojie.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/10 19:55
 * @since 1.8
 */
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values(?,?,?)",null, role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId = ?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
