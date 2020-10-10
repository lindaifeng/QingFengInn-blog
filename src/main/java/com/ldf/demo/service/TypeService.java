package com.ldf.demo.service;

import com.ldf.demo.pojo.Type;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/22 15:47
 * @code: 愿世间永无Bug!
 * @description:
 */
public interface TypeService {

    List<Type> listTypes();

    Type getType(Long typeId);

    List<Type> getAlltype();

    int saveType(Type type);

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteById(Long id);

    List<Type> listTypesAndBlogs();

}
