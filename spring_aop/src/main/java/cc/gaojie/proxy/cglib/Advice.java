package cc.gaojie.proxy.cglib;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/25 22:10
 * @since 1.8
 */
public class Advice {

    public void before(){
        System.out.println("前置增强……");
    }

    public void after(){
        System.out.println("后置增强……");
    }
}
