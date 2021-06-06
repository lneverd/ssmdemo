package com.xiaow.ssmdemo.service.impl;

import com.xiaow.ssmdemo.mapper.CategoryMapper;
import com.xiaow.ssmdemo.model.CategoryBean;
import com.xiaow.ssmdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatetoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;


    public List<CategoryBean> findALL() {
        return categoryMapper.findALL();
    }

    public void insert(CategoryBean bean) {
        categoryMapper.insert(bean);
    }

    public void update(CategoryBean bean) {
        categoryMapper.update(bean);
    }

    public void delete(int id) {
        categoryMapper.delete(id);
    }

    public CategoryBean findById(int id) {
        return categoryMapper.findById(id);
    }

    public CategoryBean findByName(String category) {
        return categoryMapper.findByName(category);
    }
}
