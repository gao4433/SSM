package cc.gaojie.dao;

import cc.gaojie.pojo.Detail;
import cc.gaojie.pojo.User;
import cc.gaojie.utils.MyBatisUtil;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

public class UserDAOTest extends TestCase {

    public void testInsertUser() {

        User user = new User(0, "zhangshan", "123", "张姗", "01.png",null);
        Detail detail = new Detail(0, "湖北省十堰市", "18888888888", "无签名", 0);

        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try {
            UserDAO UserDAO = sqlSession.getMapper(UserDAO.class);
            int i = UserDAO.insertUser(user);
            System.out.println(i);

            //h获取回填的UserId赋值给detail
            detail.setUserId(user.getUserId());

            DetailDAO detailDAO = sqlSession.getMapper(DetailDAO.class);
            int j = detailDAO.insertDetail(detail);
            System.out.println(j);

            //两次添加操作都成功才提交
            sqlSession.commit();

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    public void testQueryUser() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        User zhangshan = userDAO.queryUser("zhangshan");
        System.out.println(zhangshan);
    }
}