package cc.gaojie.proxy.jdk;

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
        final Target target = new Target();

        //增强对象
        Advice advice = new Advice();

        //返回值，就是动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                //目标对象类加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    //调用代理对象的任何方法，实质执行的都是invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        advice.before();
                        //执行目标方法
                        method.invoke(target, args);
                        //后置增强
                        advice.after();
                        return null;
                    }
                }
        );

        //调用代理对象的方法
        proxy.save();

    }
}
