package com.ldf.demo.service.impl;

import com.ldf.demo.mapper.FriendLinkMapper;
import com.ldf.demo.pojo.FriendLink;
import com.ldf.demo.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/23 10:20
 * @code: 愿世间永无Bug!
 * @description:
 */
@Service
@Transactional
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private FriendLinkMapper friendLinkMapper;

    @Override
    public List<FriendLink> listFriendLike() {
        return friendLinkMapper.listFriendLike();
    }

    @Override
    public FriendLink getFriendLink(String blogaddress) {
        return friendLinkMapper.getFriendLink(blogaddress);
    }

    @Override
    public int saveFriendLink(FriendLink friendLink) {
        friendLink.setCreateTime(new Date());
        return friendLinkMapper.saveFriendLink(friendLink);
    }

    @Override
    public FriendLink getFriendLinkById(Long id) {
        return friendLinkMapper.getFriendLinkById(id);
    }

    @Override
    public int updateFriendLink(FriendLink friendLink) {
        return friendLinkMapper.updateFriendLink(friendLink);
    }

    @Override
    public void deleteFriendLink(Long id) {
        friendLinkMapper.deleteFriendLink(id);
    }
}
