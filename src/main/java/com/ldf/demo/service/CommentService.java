package com.ldf.demo.service;

import com.ldf.demo.pojo.Comment;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/24 10:57
 * @code: 愿世间永无Bug!
 * @description:
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long id);

    void saveComment(Comment comment);

    void deleteComment(Comment comment, Long id);
}
