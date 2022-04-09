package cc.gaojie.controller;

import cc.gaojie.domain.King;
import cc.gaojie.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.WatchEvent.Kind;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    public ModelAndView save2() {
        /*
            model：模型，用于封装数据
            view：视图，用于展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据（相当于放入请求作用域中）
        modelAndView.addObject("username", "gaojie.cc");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * modelAndView对象也可以不手动创建，而是采用使用注入的方式作为方法的参数
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "Nice!");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 以字符串形式做视图和数据的返回
     */
    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "Good!");
        return "success";
    }

    /**
     * 通过注入请求对象进行视图和数据的返回
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "Beautiful!");
        return "success";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("Hello World!");
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody  //告诉SpringMVC框架不要进行页面跳转，直接数据回写
    public String save7() {
        return "Hello gaojie.cc";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws IOException {
        King king = new King();
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
    public King save9() throws IOException {
        King king = new King();
        king.setName("gaojie");
        return king;
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody  //直接回写数据而不是跳转
    public void save10(@RequestParam("name") String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody  //直接回写数据而不是跳转
    public void save11(King king) {
        System.out.println(king);
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(String[] strs) {
        System.out.println(Arrays.toString(strs));
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(@RequestBody List<King> kingList) {
        System.out.println(kingList);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody  //直接回写数据而不是跳转
    public void save15(@RequestParam(value = "name", required = false, defaultValue = "gaojie.cc") String username) {
        System.out.println(username);
    }

    /**
     * http://localhost:8080/user/quick16/gaojie
     *
     * @param username
     */
    @RequestMapping(value = "/quick16/{username}")
    @ResponseBody
    public void save16(@PathVariable(value = "username") String username) {
        System.out.println(username);
    }


    @RequestMapping(value = "/quick17")
    @ResponseBody
    public void save17(Date date) {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    /**
     * 获取User-Agent
     *
     * @param user_agent
     */
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value = "User-Agent", required = false) String user_agent) {
        System.out.println(user_agent);
    }

    /**
     * 获取cookie
     *
     * @param jsessionID
     */
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@CookieValue(value = "JSESSIONID") String jsessionID) {
        System.out.println(jsessionID);
    }

    /**
     * 单文件上传
     *
     * @param username
     * @param uploadFile
     */
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        //获取上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        //转存文件到指定位置
        uploadFile.transferTo(new File("D:\\Desktop\\upload\\" + originalFilename));
    }

    /**
     * 多文件上传
     * @param username
     * @param uploadFile
     */
    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            System.out.println(multipartFile);
            //获取上传文件的名称
            String originalFilename = multipartFile.getOriginalFilename();
            //转存文件到指定位置
            multipartFile.transferTo(new File("D:\\Desktop\\upload\\" + originalFilename));
        }

    }


}
