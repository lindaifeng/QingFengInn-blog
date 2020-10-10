package com.ldf.demo.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldf.demo.pojo.Blog;
import com.ldf.demo.pojo.Type;
import com.ldf.demo.pojo.User;
import com.ldf.demo.queryVo.BlogQuery;
import com.ldf.demo.queryVo.SearchBlog;
import com.ldf.demo.queryVo.ShowBlog;
import com.ldf.demo.service.BlogService;
import com.ldf.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: 清峰
 * @date: 2020/9/22 14:29
 * @code: 愿世间永无Bug!
 * @description: 后台博客管理控制器
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @RequestMapping("/blogs")
    public String listBlogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //按照排序字段 倒叙排序
        String orderBy = "update_time desc";
        //开始分页
        PageHelper.startPage(pageNum, 10, orderBy);
        List<BlogQuery> blogs = blogService.listBlogs();

        if (blogs != null) {
            PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogs);
            model.addAttribute("pageInfo", pageInfo);
        }
        List<Type> types = typeService.listTypes();
        model.addAttribute("types", types);
        return "admin/blogs";
    }

    //跳转到新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listTypes());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    //新增页面
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes,
                       HttpSession session) {

        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getTypeId()));
        blog.setTypeId(blog.getType().getId());
        blog.setUserId(blog.getUser().getId());

        blog.setFlag(blog.getFlag());

        int b = blogService.saveBlog(blog);
        if (b == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogs";
    }

    //跳转到博客编辑页面
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        ShowBlog blogById = blogService.getBlogById(id);
        List<Type> allType = typeService.getAlltype();
        model.addAttribute("blog", blogById);
        model.addAttribute("types", allType);
        return "admin/blogs-input";
    }

    //编辑博客
    @PostMapping("/blogs/{id}")
    public String editPost(@Valid ShowBlog showBlog, RedirectAttributes attributes) {
        int b = blogService.updateBlog(showBlog);
        if (b == 0) {
            attributes.addFlashAttribute("message", "修改失败");
        } else {
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/admin/blogs";
    }

    //删除博客
    @GetMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id,RedirectAttributes attributes){
        int b = blogService.deleteBlogById(id);
        if (b == 0) {
            attributes.addFlashAttribute("message", "删除失败");
        } else {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/blogs";
    }

    //搜索博客
    @PostMapping("/blogs/search")
    public String search( @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                          SearchBlog searchBlog,Model model){

        List<SearchBlog> blogs = blogService.searchBlogs(searchBlog);
        PageHelper.startPage(pageNum, 10);
        PageInfo<SearchBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs :: blogList";
    }
}
