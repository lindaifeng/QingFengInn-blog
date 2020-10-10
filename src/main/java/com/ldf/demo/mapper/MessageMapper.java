package com.ldf.demo.mapper;

import com.ldf.demo.pojo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/24 14:53
 * @code: 愿世间永无Bug!
 * @description:
 */
@Repository
public interface MessageMapper {
    //添加一个评论
    int saveMessage(Message message);

    //查询父级评论
    List<Message> findByParentIdNull(@Param("ParentId") Long ParentId);

    //查询一级回复
    List<Message> findByParentIdNotNull(@Param("id") Long id);

    //查询二级以及所有子集回复
    List<Message> findByReplayId(@Param("childId") Long childId);

    //删除评论
    void deleteMessage(Long id);

}
