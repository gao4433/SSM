package cc.gaojie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/25 18:25
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clazz {
    private int classId;
    private String className;
    private String classDesc;

    private List<Student> stus;
}
