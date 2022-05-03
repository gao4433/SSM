package cc.gaojie.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author gaojie  gao4433@qq.com
 * @Description     切面类
 * @date 2022/5/2 17:12
 * @since 1.8
 */
@Component("myAspect")
@Aspect
public class MyAspect {

    /**
     * 定义切点表达式
     */
    @Pointcut("execution(* cc.gaojie.anno.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("前置增强……");
    }

    @AfterReturning("pointcut()")
    public void afterRunning() {
        System.out.println("后置增强……");
    }

    @Around("MyAspect.pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强……");
        //切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强……");
        return proceed;
    }

    @AfterThrowing("MyAspect.pointcut()")
    public void afterThrowing() {  System.out.println("异常抛出增强……"); }

    @After("MyAspect.pointcut()")
    public void after() {
        System.out.println("最终增强");
    }

}
