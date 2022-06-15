package cc.gaojie.dao;

import cc.gaojie.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/15 14:51
 * @since 1.8
 */
public interface UserDao {
    public int insertUser(User user);

    public int deleteUser(int id);

    public int updateUser(User user);

    public List<User> listUsers();

    public User queryUser(int id);

    public List<User> listUserByPage1(HashMap<String, Integer> hashMap);

    public List<User> listUserByPage2(int start, int pageSize);

    public List<User> listUserByPage3(@Param("start") int start, @Param("pageSize") int pageSize);

    public int getCount();
}
