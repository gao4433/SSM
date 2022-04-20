package cc.gaojie.resolver;

import cc.gaojie.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gaojie  gao4433@qq.com
 * @Description    异常处理器类实现 HandlerExceptionResolver
 * @date 2022/4/21 1:44
 * @since 1.8
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     * 参数Exception：报异常的异常对象
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return modelAndView  要跳转的错误视图的信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        } else if (e instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
