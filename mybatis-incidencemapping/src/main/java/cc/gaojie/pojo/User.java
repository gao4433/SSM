package cc.gaojie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/23 19:55
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userRealName;
    private String userImg;

    private Detail detail;
}
