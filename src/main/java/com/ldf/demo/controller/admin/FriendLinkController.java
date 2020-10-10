package com.ldf.demo.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldf.demo.pojo.FriendLink;
import com.ldf.demo.service.FriendLinkService;
import org.attoparser.ParsingProcessingInstructionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.OptionalDouble;

/**
 * @author: 清峰
 * @date: 2020/9/23 10:15
 * @code: 愿世间永无Bug!
 * @description: 后台友链控制器
 */
@Controller
@RequestMapping("/admin")
public class FriendLinkController {

    @Autowired
    private FriendLinkService friendLinkService;
    //友链查询
    @GetMapping("/friendlinks")
    public String listFriendLink(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model){
        List<FriendLink> list = friendLinkService.listFriendLike();
        PageHelper.startPage(pageNum,10);
        PageInfo<FriendLink> pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/friendlinks";
    }
    //跳转到友链编辑页面
    @GetMapping("/friendlinks/input")
    public String input(Model model){
        model.addAttribute("friendlink",new FriendLink());
        return "admin/friendlinks-input";
    }
    //保存友链信息
    @PostMapping("/friendlinks")
    public String post(@Valid FriendLink friendLink, RedirectAttributes attributes){
        FriendLink f1 = friendLinkService.getFriendLink(friendLink.getBlogaddress());
        if (f1!=null){
            attributes.addFlashAttribute("message","友链重复,已存在该朋友呦!");
            return "redirect:/admin/friendlinks/input";
        }
        int f = friendLinkService.saveFriendLink(friendLink);
        if (f==0){
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/friendlinks";
    }
    //跳转到编辑友链页面
    @GetMapping("/friendlinks/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("friendlink",friendLinkService.getFriendLinkById(id));
        return "admin/friendlinks-input";
    }
    //编辑保存
    @PostMapping("/friendlinks/{id}")
    public String editPost(@Valid FriendLink friendLink,RedirectAttributes attributes){

        int f = friendLinkService.updateFriendLink(friendLink);
        if (f==0){
            attributes.addFlashAttribute("message","修改失败");
        }else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/friendlinks";
    }
    //删除友链
    @GetMapping("/friendlinks/{id}/delete")
    public String deleteFriendLink(@PathVariable Long id,RedirectAttributes attributes){
        friendLinkService.deleteFriendLink(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/friendlinks";
    }

}
