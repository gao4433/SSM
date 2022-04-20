package cc.gaojie.interceptor;

import cc.gaojie.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/19 23:11
 * @since 1.8
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录，本质是判断session中是否有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            //没有登录，不放行
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //放行，访问目标资源
        return true;

    }
}
