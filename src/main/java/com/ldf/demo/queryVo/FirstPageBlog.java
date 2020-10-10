package com.ldf.demo.queryVo;

import java.util.Date;

/**
 * @author: 清峰
 * @date: 2020/9/22 13:23
 * @code: 愿世间永无Bug!
 * @description: 博客首页数据实体类
 */
public class FirstPageBlog {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;

    //User
        private String nickname;
        private String avatar;

        @Override
        public String toString() {
            return "FirstPageBlog{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", firstPicture='" + firstPicture + '\'' +
                    ", views=" + views +
                    ", commentCount=" + commentCount +
                    ", updateTime=" + updateTime +
                    ", description='" + description + '\'' +
                    ", typeName='" + typeName + '\'' +
                    ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public FirstPageBlog() {
    }
}
