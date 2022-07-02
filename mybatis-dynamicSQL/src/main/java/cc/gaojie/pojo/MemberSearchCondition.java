package cc.gaojie.pojo;

import lombok.Data;

/**
 * @author 高杰
 */
@Data
public class MemberSearchCondition {
    private String gender;
    private Integer minAge;
    private Integer maxAge;
    private String city;
}
