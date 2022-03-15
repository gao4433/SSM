package cc.gaojie.dao.impl;

import cc.gaojie.dao.UserDao;
import cc.gaojie.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author gaojie  gao4433@qq.com
 * @Description UserDao接口实现类
 * @date 2022/3/12 17:56
 * @since 1.8
 */
public class UserDaoImpl implements UserDao {

    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private String userName;
    private int age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 无参构造
     *//*
    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建…………");
    }

    public void init() {
        System.out.println("初始化方法…………");
    }

    public void destroy() {
        System.out.println("销毁方法…………");
    }*/

    @Override
    public void save() {
        /*System.out.println(userName+ "------" + age);*/
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running…………");
    }


}
