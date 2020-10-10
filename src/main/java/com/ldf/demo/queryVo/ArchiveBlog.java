package com.ldf.demo.queryVo;

import java.util.Date;

/**
 * @author: 清峰
 * @date: 2020/9/24 14:31
 * @code: 愿世间永无Bug!
 * @description:
 */
public class ArchiveBlog {

    private Long id;
    private String title;
    private Date createTime;

    @Override
    public String toString() {
        return "ArchiveBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ArchiveBlog() {
    }
}
