package com.ldf.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldf.demo.pojo.Comment;
import com.ldf.demo.queryVo.*;
import com.ldf.demo.service.BlogService;
import com.ldf.demo.service.CommentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.SocketTimeoutException;
import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/24 9:45
 * @code: 愿世间永无Bug!
 * @description:
 */
@Controller
public class IndexShowController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService ;


    @GetMapping("/")
    public String index(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model){
        PageHelper.startPage(pageNum,10);
        //第一页博客展示
        List<FirstPageBlog> firstPageBlogs = blogService.getFirstPageBlogs();
        //最热博客推荐
        List<RecommendBlog> recommendBlogs = blogService.recommendedBlogs();

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlogs);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendedBlogs",recommendBlogs);
        return "index";
    }

    //搜索博客
    @PostMapping("/search")
    public String search(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                         @RequestParam(name = "query")String query,Model model){
        PageHelper.startPage(pageNum,1000);
        List<FirstPageBlog> blogs = blogService.getSearchBlogs(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        return "search";
    }


//    跳转到博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        DetailedBlog blog = blogService.getDetailedBlogById(id);

        List<Comment> comments = commentService.listCommentByBlogId(id);
        System.out.println(comments);
        model.addAttribute("blog",blog);
        model.addAttribute("comments",comments);
        return "blog";
    }


//查询底部栏博客信息
    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model){
        int blogTotal = blogService.getBlogTotal();
        model.addAttribute("blogTotal",blogTotal);
        int blogViewTotal = blogService.getBlogViewTotal();
        model.addAttribute("blogViewTotal",blogViewTotal);
        int blogCommentTotal = blogService.getBlogCommentTotal();
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        int blogMessageTotal = blogService.getBlogMessageTotal();
        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "index :: blogMessage";
    }



}
