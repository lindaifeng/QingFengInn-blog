package com.ldf.demo.service.impl;

import com.ldf.demo.NotFountException;
import com.ldf.demo.mapper.BlogMapper;
import com.ldf.demo.pojo.Blog;
import com.ldf.demo.queryVo.*;
import com.ldf.demo.service.BlogService;
import com.ldf.demo.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/22 14:33
 * @code: 愿世间永无Bug!
 * @description:
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<BlogQuery> listBlogs() {
        return blogMapper.listBlogs();
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogMapper.getBolgById(id);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogMapper.updateBlog(showBlog);
    }

    @Override
    public int deleteBlogById(Long id) {
        return blogMapper.deleteBlogById(id);
    }

    @Override
    public List<SearchBlog> searchBlogs(SearchBlog searchBlog) {
        return blogMapper.searchBlogs(searchBlog);
    }

    @Override
    public List<FirstPageBlog> getFirstPageBlogs() {
        return blogMapper.getFirstPageBlogs();
    }

    @Override
    public List<RecommendBlog> recommendedBlogs() {
        return blogMapper.recommendedBlogs();
    }

    @Override
    public List<FirstPageBlog> getSearchBlogs(String query) {
        return blogMapper.getSearchBlogs(query);
    }

    @Override
    public DetailedBlog getDetailedBlogById(Long id) {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlogById(id);
        if (detailedBlog==null){
            throw new NotFountException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogMapper.updateViews(id);
        blogMapper.getCommentCountById(id);
        return detailedBlog;
    }

    @Override
    public Integer getBlogTotal() {
        return blogMapper.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogMapper.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogMapper.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogMapper.getBlogMessageTotal();
    }

    @Override
    public List<FirstPageBlog> getBlogsByTypeId(Long id) {
        return blogMapper.getBlogsByTypeId(id);
    }

    @Override
    public List<ArchiveBlog> getArchiveBlogs() {
        return blogMapper.getArchiveBlogs();
    }

}
