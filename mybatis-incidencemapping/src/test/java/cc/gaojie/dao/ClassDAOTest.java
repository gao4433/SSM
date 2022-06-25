package cc.gaojie.dao;

import cc.gaojie.pojo.Clazz;
import cc.gaojie.utils.MyBatisUtil;
import junit.framework.TestCase;

public class ClassDAOTest extends TestCase {

    public void testQueryClass() {
        ClassDAO classDAO = MyBatisUtil.getMapper(ClassDAO.class);
        Clazz stus = classDAO.queryClass(1);
        System.out.println(stus);
    }
}