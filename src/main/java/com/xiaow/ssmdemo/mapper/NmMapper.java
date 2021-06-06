package com.xiaow.ssmdemo.mapper;

import com.xiaow.ssmdemo.model.NmBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NmMapper {

    public void insert(NmBean bean);
    public void update(NmBean bean);
    public void delete(@Param("id") int id);
    public List<NmBean> findByNid(@Param("nid") int nid);

}
