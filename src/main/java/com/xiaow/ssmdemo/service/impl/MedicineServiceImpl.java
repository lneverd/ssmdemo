package com.xiaow.ssmdemo.service.impl;

import com.xiaow.ssmdemo.mapper.MedicineMapper;
import com.xiaow.ssmdemo.model.MedicineBean;
import com.xiaow.ssmdemo.service.MedicineService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineMapper medicineMapper;

    public List<MedicineBean> findALL(@Param("cid")Integer cid) {
        return medicineMapper.findALL(cid);
    }

    public void insert(MedicineBean bean) {
        medicineMapper.insert(bean);
    }

    public void update(MedicineBean bean) {
        medicineMapper.update(bean);
    }

    public void delete(int id) {
        medicineMapper.delete(id);
    }

    public MedicineBean findById(int id) {
        return medicineMapper.findById(id);
    }

    public MedicineBean findByName(String category) {
        return medicineMapper.findByName(category);
    }

    public List<MedicineBean> findByCid(int cid) {
        return medicineMapper.findByCid(cid);
    }
}
