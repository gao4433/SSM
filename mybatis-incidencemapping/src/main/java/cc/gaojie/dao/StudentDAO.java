package cc.gaojie.dao;

import cc.gaojie.pojo.Student;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/25 19:42
 * @since 1.8
 */
public interface StudentDAO {
    //    public Student queryStudentByCid(int cid);
    public Student queryStudentBySid(String sid);
}
