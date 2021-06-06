package com.xiaow.ssmdemo.mapper;

import com.xiaow.ssmdemo.model.MedicineBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineMapper {

    public List<MedicineBean> findALL(@Param("cid")Integer cid);
    public void insert(MedicineBean bean);
    public void update(MedicineBean bean);
    public void delete(@Param("id") int id);
    public MedicineBean findById(@Param("id")int id);
    public MedicineBean findByName(String category);

    public List<MedicineBean> findByCid(@Param("cid")int cid);

}
