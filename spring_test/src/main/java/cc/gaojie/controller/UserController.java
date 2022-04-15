package cc.gaojie.controller;

import cc.gaojie.domain.Role;
import cc.gaojie.domain.User;
import cc.gaojie.service.RoleService;
import cc.gaojie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/12 11:06
 * @since 1.8
 */
@Controller     //URL的第一级访问目录
@RequestMapping("/user")    //自动实例化
public class UserController {

    @Autowired    //注入userService
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/saveUI")     //映射路径
    public ModelAndView saveUI(){
        List<Role> roleList = roleService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        //跳转到用户添加页面
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/list")     //映射路径
    public ModelAndView list(){
        List<User> userList = userService.list();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/del/{userId}")     //Restful风格参数
    public String del(@PathVariable("userId") Long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }

}
