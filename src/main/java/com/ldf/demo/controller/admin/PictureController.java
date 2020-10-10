package com.ldf.demo.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldf.demo.pojo.Picture;
import com.ldf.demo.service.PictureService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/23 19:57
 * @code: 愿世间永无Bug!
 * @description: 图片管理控制器
 */
@Controller
@RequestMapping("/admin")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/pictures")
    public String listPicture(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, Model model){
        List<Picture> list = pictureService.listPictures();
        PageHelper.startPage(pageNum,10);
        PageInfo<Picture> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }

    @GetMapping("/pictures/input")
    public String input(Model model){
        model.addAttribute("picture",new Picture());
        return "admin/pictures-input";
    }

    @PostMapping("/pictures")
    public String post(@Valid Picture picture, RedirectAttributes attributes){
        int p = pictureService.savePicture(picture);
        if (p==0){
            attributes.addFlashAttribute("message","新增失败");
            return "redirect:/admin/pictures/input";
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/pictures";
    }
/*@PostMapping("/pictures")
public String post( @RequestParam("file") MultipartFile file,@Valid Picture picture, RedirectAttributes attributes){
    int p = pictureService.savePicture(picture);
    if (p==0){
        attributes.addFlashAttribute("message","新增失败");
        return "redirect:/admin/pictures/input";
    }else {
        attributes.addFlashAttribute("message","新增成功");
    }
    return "redirect:/admin/pictures";
}*/



    @GetMapping("/pictures/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("picture",pictureService.getPictureById(id));
        return "admin/pictures-input";
    }

    @PostMapping("/pictures/{id}")
    public String editPost(@Valid Picture picture,RedirectAttributes attributes){
        int p = pictureService.updatePicture(picture);
        if (p==0){
            attributes.addFlashAttribute("message","修改失败");
        }else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/pictures";
    }

    @GetMapping("/pictures/{id}/delete")
    public String deletePicture(@PathVariable Long id,RedirectAttributes attributes){
        pictureService.deletePicture(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/pictures";
    }

}
