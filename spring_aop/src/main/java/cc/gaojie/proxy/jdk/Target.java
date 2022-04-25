package cc.gaojie.proxy.jdk;

import cc.gaojie.proxy.jdk.TargetInterface;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/25 22:09
 * @since 1.8
 */
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running……");
    }
}
