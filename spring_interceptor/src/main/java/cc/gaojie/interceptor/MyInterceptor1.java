package cc.gaojie.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gaojie  gao4433@qq.com
 * @Description HandlerInterceptor 接口中没有需要我们修饰的方法，是因为在接口内部所有的抽象方法都用 default 关键字修饰了。但方法体都是空的，因此需要我们手动覆盖。
 * @date 2022/4/19 11:11
 * @since 1.8
 */
public class MyInterceptor1 implements HandlerInterceptor {

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
        System.out.println("preHandle……");
        String param = request.getParameter("param");
        if ("yes".equals(param)){
            //携带参数yes放行
            return true;
        } else {
            //不携带参数yes则转发到error.jsp页面
            request.getRequestDispatcher("/error.jsp").forward(request,response);  //转发
            return false;
        }

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
        modelAndView.addObject("name","SpringMVC");
        System.out.println("postHandle……");
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
        System.out.println("afterCompletion……");
    }

}
