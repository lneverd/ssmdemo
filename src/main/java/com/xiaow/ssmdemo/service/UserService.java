package com.xiaow.ssmdemo.service;

import com.xiaow.ssmdemo.model.UserBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaow
 */
@Service
public interface UserService {
    public UserBean getOneByName(String username);
    public List getDramic(UserBean userBean);
    public void add(UserBean userBean);
    public void delete(Integer id);
    public void update(UserBean userBean);
}
