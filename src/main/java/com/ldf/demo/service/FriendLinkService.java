package com.ldf.demo.service;

import com.ldf.demo.pojo.FriendLink;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/23 10:20
 * @code: 愿世间永无Bug!
 * @description:
 */
public interface FriendLinkService {
    List<FriendLink> listFriendLike();

    FriendLink getFriendLink(String blogaddress);


    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLinkById(Long id);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);
}
