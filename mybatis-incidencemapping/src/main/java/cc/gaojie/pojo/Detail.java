package cc.gaojie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/23 20:01
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Detail {
    private int detailId;
    private String userAddr;
    private String userTel;
    private String userDesc;
    private int userId;
}
