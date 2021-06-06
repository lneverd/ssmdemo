package com.xiaow.ssmdemo.service;

import com.xiaow.ssmdemo.model.PatientBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    public List<PatientBean> findALL(PatientBean bean);
    public void insert(PatientBean bean);
    public void update(PatientBean bean);
    public void updateByIdCard(PatientBean bean);

    public PatientBean findById(@Param("id") int id);
    public PatientBean findByName(String name);
    public PatientBean findByIdCard(@Param("idcard")String idcard);

    public List<PatientBean> getHistory(PatientBean bean);
}
