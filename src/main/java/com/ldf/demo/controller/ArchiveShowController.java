package com.ldf.demo.controller;

import com.ldf.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 清峰
 * @date: 2020/9/24 14:27
 * @code: 愿世间永无Bug!
 * @description:
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("blogs",blogService.getArchiveBlogs());
        return "archives";
    }
}
