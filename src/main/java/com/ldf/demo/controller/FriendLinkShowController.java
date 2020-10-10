package com.ldf.demo.controller;

import com.ldf.demo.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 清峰
 * @date: 2020/9/24 15:54
 * @code: 愿世间永无Bug!
 * @description:
 */
@Controller
public class FriendLinkShowController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String FriendLinks(Model model){
        model.addAttribute("friendlinks",friendLinkService.listFriendLike());
        return "friends";
    }
}
