package cc.gaojie.dao;

import cc.gaojie.pojo.Member;
import cc.gaojie.pojo.MemberSearchCondition;
import cc.gaojie.utils.MyBatisUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberDAOTest extends TestCase {

    @Test
    public void testSearchMember() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("minAge",18);
        params.put("maxAge",28);
        params.put("city","武汉");

        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMember(params);

        for (Member m: members) {
            System.out.println(m);
        }
    }

    public void testSearchMemberByCity2() {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("武汉");
        cities.add("十堰");

        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMemberByCity(cities);

        for (Member m: members) {
            System.out.println(m);
        }
    }

/*    @Test
    public void testSearchMember3() {
        MemberSearchCondition params = new MemberSearchCondition();
        params.setGender("女");
        params.setMinAge(21);
        params.setMaxAge(30);

        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMember(params);

        for (Member m: members) {
            System.out.println(m);
        }
    }*/

}