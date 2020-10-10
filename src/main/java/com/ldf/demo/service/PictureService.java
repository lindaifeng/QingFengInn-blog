package com.ldf.demo.service;

import com.ldf.demo.pojo.Picture;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/23 20:01
 * @code: 愿世间永无Bug!
 * @description:
 */
public interface PictureService {
    List<Picture> listPictures();

    int savePicture(Picture picture);

    Picture getPictureById(Long id);

    int updatePicture(Picture picture);

    void deletePicture(Long id);
}
