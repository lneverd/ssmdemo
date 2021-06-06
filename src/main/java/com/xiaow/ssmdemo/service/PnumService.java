package com.xiaow.ssmdemo.service;

import com.xiaow.ssmdemo.model.PnumBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PnumService {

    public List<PnumBean> findALL(PnumBean bean);
    public void insert(PnumBean bean);
    public void update(PnumBean bean);
    public PnumBean findById(@Param("id") int id);
    public PnumBean findByPid(int pid);
    public PnumBean findByUid(int uid);
}
