package com.xiaow.ssmdemo.mapper;


import com.xiaow.ssmdemo.model.UserBean;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

public interface UserMapper {
    public UserBean selectUser(long userId);
    public UserBean selectUserByName(String username);
    public List<UserBean> list();
    public List<UserBean> selectUserAuto(UserBean userBean);
    public void add(UserBean userBean);
    public void delete(Integer id);
    public void update(UserBean userBean);
}
