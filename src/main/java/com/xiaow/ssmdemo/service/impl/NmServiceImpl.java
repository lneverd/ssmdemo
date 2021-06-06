package com.xiaow.ssmdemo.service.impl;

import com.xiaow.ssmdemo.mapper.NmMapper;
import com.xiaow.ssmdemo.mapper.PatientMapper;
import com.xiaow.ssmdemo.model.NmBean;
import com.xiaow.ssmdemo.model.PatientBean;
import com.xiaow.ssmdemo.service.NmService;
import com.xiaow.ssmdemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NmServiceImpl implements NmService {

    @Autowired
    NmMapper mapper;

    public void insert(NmBean bean) {
        mapper.insert(bean);
    }

    public void update(NmBean bean) {
        mapper.update(bean);
    }

    public void delete(int id) {
        mapper.delete(id);
    }

    public List<NmBean> findByNid(int nid) {
        return mapper.findByNid(nid);
    }
}
