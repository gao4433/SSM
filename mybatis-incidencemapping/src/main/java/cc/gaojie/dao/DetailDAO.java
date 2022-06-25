package cc.gaojie.dao;

import cc.gaojie.pojo.Detail;
import cc.gaojie.pojo.User;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/6/23 20:47
 * @since 1.8
 */
public interface DetailDAO {
    public int insertDetail(Detail detail);
    public Detail queryDetailByUid(int uid);
}
