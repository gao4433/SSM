package cc.gaojie.dao;

import cc.gaojie.pojo.Member;
import cc.gaojie.pojo.MemberSearchCondition;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {

    /**
     * 在多条件查询中，如果查询条件不确定，可以直接使用HashMap作为参数
     * -> 优点：无需单独定义传递查询条件的类
     * -> 缺点：当向Map中存放参数时，key必须与动态sql保持一致（）
     * @param params
     * @return
     */
    public List<Member> searchMember(HashMap<String, Object> params);


    // 也可以定义专门用于存放查询条件的实体类存放参数
    //优点：设置参数时无需关注属性名
    //缺点：需要单独定义一个类来封装参数

    /**
     * 可以定义专门用于存放查询条件的实体类存放参数
     * -> 优点：设置参数时无需关注属性名
     * -> 缺点：需要单独定义一个类来封装参数
     * @param params
     * @return
     */
//    public List<Member> searchMember(MemberSearchCondition params);

    /**
     * 只查询指定几个城市的会员
     * @param cities
     * @return
     */
    public List<Member> searchMemberByCity(List<String> cities);
//
//    //根据昵称查询用户信息——模糊查询
    public List<Member> searchMemberByNick(@Param("keyWord") String keyWord);
//
//    public Member queryMemberById(int mid);
//
//    public int updateMember(@Param("mid") int mid,@Param("age") int age);
}