package cc.gaojie.dao;

import cc.gaojie.pojo.Course;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/26 21:23
 * @since 1.8
 */
public interface CourseDAO {
    public Course queryCourseById(int courseId);
}
