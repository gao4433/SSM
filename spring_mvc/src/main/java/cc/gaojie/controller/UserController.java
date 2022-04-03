package cc.gaojie.controller;

import cc.gaojie.domain.King;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.nio.file.WatchEvent.Kind;

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

    @RequestMapping(value = "/quick2")
    public ModelAndView save2 () {
        /*
            model：模型，用于封装数据
            view：视图，用于展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据（相当于放入请求作用域中）
        modelAndView.addObject("username","gaojie.cc");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * modelAndView对象也可以不手动创建，而是采用使用注入的方式作为方法的参数
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/quick3")
    public ModelAndView save3 (ModelAndView modelAndView) {
        modelAndView.addObject("username","Nice!");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 以字符串形式做视图和数据的返回
     */
    @RequestMapping(value = "/quick4")
    public String save4 (Model model) {
        model.addAttribute("username","Good!");
        return "success";
    }

    /**
     * 通过注入请求对象进行视图和数据的返回
     * @param request
     * @return
     */
     @RequestMapping(value = "/quick5")
     public String save5 (HttpServletRequest request) {
        request.setAttribute("username","Beautiful!");
     return "success";
     }

     @RequestMapping(value = "/quick6")
     public void save6 (HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello World!");
     }

     @RequestMapping(value = "/quick7")
     @ResponseBody  //告诉SpringMVC框架不要进行页面跳转，直接数据回写
     public String save7 () {
        return "Hello gaojie.cc";
     }

     @RequestMapping(value = "/quick8")
     @ResponseBody
     public String save8 () throws IOException {
         King king =new King();
         king.setName("gaojie");
         king.setAge(22);
         //使用json转换工具将对象转换为json格式字符串返回
         ObjectMapper objectMapper = new ObjectMapper();
         String json = objectMapper.writeValueAsString(king);
         return json;
         //return "{\"username\":\"gaojie\",\"age\":22}";
     }

     @RequestMapping(value = "/quick9")
     @ResponseBody
     public King save9 () throws IOException {
         King king =new King();
         king.setName("gaojie");
         return king;
     }

}
