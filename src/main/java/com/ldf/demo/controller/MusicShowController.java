package com.ldf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 清峰
 * @date: 2020/9/24 14:48
 * @code: 愿世间永无Bug!
 * @description:
 */
@Controller
public class MusicShowController {

    @GetMapping("/music")
    public String music(){
        return "music";
    }
}
