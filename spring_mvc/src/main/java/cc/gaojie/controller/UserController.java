package cc.gaojie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.RequestWrapper;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/22 11:15
 * @since 1.8
 */
//放进Spring容器
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String sava() {
        System.out.println("Controller save running……");
        //在跳转时省略前缀和后缀
        return "success.jsp";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2 () {
        /*
            model：模型，用于封装数据
            view：视图，用于展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据（相当于放入请求作用域中）
        modelAndView.addObject("username","gaojie");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
