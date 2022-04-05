package cc.gaojie.domain;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/4 0:11
 * @since 1.8
 */
public class VO {
    private List<King> kingList;

    public List<King> getKingList() {
        return kingList;
    }

    public void setKingList(List<King> kingList) {
        this.kingList = kingList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "kingList=" + kingList +
                '}';
    }
}
