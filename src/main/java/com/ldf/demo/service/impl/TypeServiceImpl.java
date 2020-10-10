package com.ldf.demo.service.impl;

import com.ldf.demo.mapper.TypeMapper;
import com.ldf.demo.pojo.Type;
import com.ldf.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 清峰
 * @date: 2020/9/22 15:47
 * @code: 愿世间永无Bug!
 * @description:
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> listTypes() {
        return typeMapper.listTypes();
    }

    @Override
    public Type getType(Long typeId) {
        return typeMapper.getType(typeId);
    }

    @Override
    public List<Type> getAlltype() {
        return typeMapper.listTypes();
    }

    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int deleteById(Long id) {
        return typeMapper.deleteById(id);
    }

    @Override
    public List<Type> listTypesAndBlogs() {
        return typeMapper.listTypesAndBlogs();
    }
}
