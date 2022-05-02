package cc.gaojie.aop;

/**
 * @author gaojie  gao4433@qq.com
 * @Description     目标接口
 * @date 2022/4/25 22:09
 * @since 1.8
 */
public class Target implements TargetInterface {

    @Override
    public void save() {
        System.out.println("save running……");
        int i = 1/0;
    }
}
