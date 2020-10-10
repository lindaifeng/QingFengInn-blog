package com.ldf.demo.mapper;

import com.ldf.demo.pojo.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/22 15:48
 * @code: 愿世间永无Bug!
 * @description:
 */
@Repository
public interface TypeMapper {

    List<Type> listTypes();

    Type getType(Long typeId);

    int saveType(Type type);

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteById(Long id);

    List<Type> listTypesAndBlogs();

}
