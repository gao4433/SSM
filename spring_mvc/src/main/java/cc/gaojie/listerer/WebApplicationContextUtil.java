package cc.gaojie.listerer;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/21 20:51
 * @since 1.8
 */
public class WebApplicationContextUtil {

    public static ApplicationContext getWebApplicationContext(ServletContext servletContext) {
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
