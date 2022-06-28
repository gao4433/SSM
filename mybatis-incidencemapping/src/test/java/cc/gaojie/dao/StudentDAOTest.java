package cc.gaojie.dao;

import cc.gaojie.pojo.Student;
import cc.gaojie.utils.MyBatisUtil;
import junit.framework.TestCase;

public class StudentDAOTest extends TestCase {

    public void testQueryStudentBySid() {
        StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
        Student student = studentDAO.queryStudentBySid("1004");
        System.out.println(student);
    }
}