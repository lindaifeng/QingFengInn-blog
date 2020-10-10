package com.ldf.demo.pojo;

import sun.management.counter.perf.PerfInstrumentation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/22 12:59
 * @code: 愿世间永无Bug!
 * @description: 分类实体类
 */
public class Type {

    private Long id;
    private String name;

    private List<Blog> blogs = new ArrayList<>();

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Type() {
    }
}
