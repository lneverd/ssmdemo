package com.xiaow.ssmdemo.mapper;

import com.xiaow.ssmdemo.model.CategoryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    public List<CategoryBean> findALL();
    public void insert(CategoryBean bean);
    public void update(CategoryBean bean);
    public void delete(@Param("id") int id);
    public CategoryBean findById(@Param("id")int id);
    public CategoryBean findByName(String category);

}
