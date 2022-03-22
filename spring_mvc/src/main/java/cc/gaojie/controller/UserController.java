package cc.gaojie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/3/22 11:15
 * @since 1.8
 */
//放进Spring容器
@Controller
public class UserController {

    //标注映射关系
    @RequestMapping("/quick")
    public String sava() {
        System.out.println("Controller save running……");
        return "success.jsp";
    }
}
