package com.xiaow.ssmdemo.service;

import com.xiaow.ssmdemo.model.CategoryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    public List<CategoryBean> findALL();
    public void insert(CategoryBean bean);
    public void update(CategoryBean bean);
    public void delete(@Param("id") int id);
    public CategoryBean findById(@Param("id")int id);
    public CategoryBean findByName(String category);
}
