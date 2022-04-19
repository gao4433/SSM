package cc.gaojie.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/19 13:27
 * @since 1.8
 */
public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 在目标方法执行之前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle2222……");
        return true;
    }

    /**
     * 在目标方法执行之后，视图对象返回之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle2222……");
    }


    /**
     * 在整个流程都执行之后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion2222……");
    }

}
