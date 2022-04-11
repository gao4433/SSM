package cc.gaojie.controller;

import cc.gaojie.domain.Role;
import cc.gaojie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author gaojie  gao4433@qq.com
 * @Description
 * @date 2022/4/10 18:40
 * @since 1.8
 */
@RequestMapping("/role")   //指定请求URL的第一级访问目录，与方法上的虚拟地址拼接
@Controller //在web层类上实例化Bean（放入到Spring容器中）
public class RoleController {

    @Autowired    //根据类型注入依赖注入roleService
    private RoleService roleService;
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/list")   //将请求虚拟地址映射到具体的方法上
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        //设置模型
        modelAndView.addObject("roleList",roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
