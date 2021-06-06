package com.xiaow.ssmdemo.service.impl;

import com.xiaow.ssmdemo.mapper.PatientMapper;
import com.xiaow.ssmdemo.mapper.PnumMapper;
import com.xiaow.ssmdemo.model.PnumBean;
import com.xiaow.ssmdemo.service.PatientService;
import com.xiaow.ssmdemo.service.PnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PnumServiceImpl implements PnumService {

    @Autowired
    PnumMapper mapper;

    public List<PnumBean> findALL(PnumBean bean) {
        return mapper.findALL(bean);
    }

    public void insert(PnumBean bean) {
        mapper.insert(bean);
    }

    public void update(PnumBean bean) {
        mapper.update(bean);
    }

    public PnumBean findById(int id) {
        return mapper.findById(id);
    }

    public PnumBean findByPid(int pid) {
        return mapper.findByPid(pid);
    }

    public PnumBean findByUid(int uid) {
        return mapper.findByUid(uid);
    }
}
