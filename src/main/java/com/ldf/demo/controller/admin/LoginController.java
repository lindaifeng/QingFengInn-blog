package com.ldf.demo.controller.admin;

import com.ldf.demo.pojo.User;
import com.ldf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author: 清峰
 * @date: 2020/9/22 13:31
 * @code: 愿世间永无Bug!
 * @description: 管理员登录界面
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    //跳转到登录页面
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }
    //跳转到首页
    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }

    //登录检验
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUsernameAndPassword(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }

    //注销功能
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "admin/login";
    }

}
