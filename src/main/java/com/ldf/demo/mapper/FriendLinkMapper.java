package com.ldf.demo.mapper;

import com.ldf.demo.pojo.FriendLink;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/23 10:20
 * @code: 愿世间永无Bug!
 * @description:
 */
@Repository
public interface FriendLinkMapper {
    List<FriendLink> listFriendLike();

    FriendLink getFriendLink(String blogaddress);

    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLinkById(Long id);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);
}
