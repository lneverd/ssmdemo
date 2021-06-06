package com.xiaow.ssmdemo.service.impl;

import com.xiaow.ssmdemo.mapper.UserMapper;
import com.xiaow.ssmdemo.model.UserBean;
import com.xiaow.ssmdemo.service.UserService;
import com.xiaow.ssmdemo.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaow
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    public UserBean getOneByName(String username) {
        return userMapper.selectUserByName(username);
    }
    public List getDramic(UserBean userBean) {
        if (userBean == null) {
            return userMapper.list();
        }
        return userMapper.selectUserAuto(userBean);
    }
    public void add(UserBean userBean) {
        userMapper.add(userBean);
    }
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    public void update(UserBean userBean) {
        List<UserBean> userBeans = userMapper.selectUserAuto(new UserBean().setId(userBean.getId()));
        UserBean userBean1 = userBeans.get(0);
        ObjectUtil.copyNotNullProperties(userBean,userBean1);
        userMapper.update(userBean1);
    }
}
