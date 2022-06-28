package cc.gaojie.dao;

import cc.gaojie.pojo.Course;
import cc.gaojie.utils.MyBatisUtil;
import junit.framework.TestCase;
import org.junit.Test;

public class CourseDAOTest extends TestCase {

    @Test
    public void testQueryCourseById() {
        CourseDAO courseDAO = MyBatisUtil.getMapper(CourseDAO.class);
        Course course = courseDAO.queryCourseById(1);
        System.out.println(course);
    }
}