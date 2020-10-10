package com.ldf.demo.controller;

import com.ldf.demo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 清峰
 * @date: 2020/9/24 15:59
 * @code: 愿世间永无Bug!
 * @description: 前台照片墙控制器
 */
@Controller
public class PictureShowController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String pictures(Model model){
        model.addAttribute("pictures",pictureService.listPictures());
        return "picture";
    }
}
