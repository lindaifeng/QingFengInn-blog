package com.ldf.demo.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldf.demo.pojo.Type;
import com.ldf.demo.queryVo.BlogQuery;
import com.ldf.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yaml.snakeyaml.events.Event;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/23 8:51
 * @code: 愿世间永无Bug!
 * @description: 分类控制器
 */

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String listTypes(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        //按照排序字段 倒叙排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 10, orderBy);
        List<Type> types = typeService.listTypes();

        if (types != null) {
            PageInfo<Type> pageInfo = new PageInfo<>(types);
            model.addAttribute("pageInfo", pageInfo);
        }
        return "admin/types";
    }

    //跳转到输入页面
    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    //新增分类
    @PostMapping("/types")
    public String post(@Valid Type type, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复分类");
            return "redirect:/admin/types/input";
        }

        int b = typeService.saveType(type);
        if (b == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

    //跳转到分类编辑页面
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/types-input";
    }

    //编辑保存
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, RedirectAttributes attributes) {
        int t = typeService.updateType(type);
        if (t == 0) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/types";
    }

    //删除分类
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id, RedirectAttributes attributes) {
        int b = typeService.deleteById(id);
        if (b==0) {
            attributes.addFlashAttribute("message", "删除失败,有博客绑定该分类！");
        } else {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/types";
    }
}
