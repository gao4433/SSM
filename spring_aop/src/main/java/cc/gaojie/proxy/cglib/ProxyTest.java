package cc.gaojie.proxy.cglib;

import cc.gaojie.proxy.jdk.Target;
import cc.gaojie.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/25 22:12
 * @since 1.8
 */
public class ProxyTest {

    public static void main(String[] args) {

        //目标对象
        final cc.gaojie.proxy.jdk.Target target = new Target();

        //增强对象
        Advice advice = new Advice();

        //返回值，就是动态生成的代理对象，基于cglib
        //1. 创建增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(Target.class);
        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects,
                                    MethodProxy methodProxy) throws Throwable {
                //执行前置
                System.out.println("前置代码增强....");
                //执行目标
                Object invoke = method.invoke(target, objects);
                //执行后置
                System.out.println("后置代码增强....");
                return invoke;
            }
        });
        //创建代理对象
        Target proxy = (Target) enhancer.create();

        //测试,当调用接口的任何方法时，代理对象的代码都无序修改
        proxy.save();
    }
}
