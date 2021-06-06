package com.xiaow.ssmdemo.service.impl;

import com.xiaow.ssmdemo.mapper.CategoryMapper;
import com.xiaow.ssmdemo.mapper.PatientMapper;
import com.xiaow.ssmdemo.model.CategoryBean;
import com.xiaow.ssmdemo.model.PatientBean;
import com.xiaow.ssmdemo.service.CategoryService;
import com.xiaow.ssmdemo.service.PatientService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientMapper mapper;

    public List<PatientBean> findALL(PatientBean bean) {
        return mapper.findALL(bean);
    }

    public void insert(PatientBean bean) {
        mapper.insert(bean);
    }

    public void update(PatientBean bean) {
        mapper.update(bean);
    }

    public void updateByIdCard(PatientBean bean) {
        mapper.updateByIdCard(bean);
    }

    public PatientBean findById(int id) {
        return mapper.findById(id);
    }

    public PatientBean findByName(String name) {
        return mapper.findByName(name);
    }

    public PatientBean findByIdCard(String idcard) {
        return mapper.findByIdCard(idcard);
    }

    public List<PatientBean> getHistory(PatientBean bean) {
        return mapper.getHistory(bean);
    }
}
