package com.xiaow.ssmdemo.service;

import com.xiaow.ssmdemo.model.NmBean;
import com.xiaow.ssmdemo.model.PatientBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NmService {

    public void insert(NmBean bean);
    public void update(NmBean bean);
    public void delete(@Param("id") int id);
    public List<NmBean> findByNid(@Param("nid") int nid);
}
