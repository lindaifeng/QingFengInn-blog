package com.ldf.demo.service;

import com.ldf.demo.pojo.Message;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/24 14:52
 * @code: 愿世间永无Bug!
 * @description:
 */
public interface MessageService {
    List<Message> listMessages();

    void saveMessage(Message message);

    void deleteMessage(Long id);
}
