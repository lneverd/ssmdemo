package com.xiaow.ssmdemo.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PageUtil implements Serializable {
    private int code;     //200 正常 非200 不正常
    private String msg;
    private Object data;
    private Long total;  //总共数据数
    private Long current;  //当前页
    private Long pages;  //页数
    private Long size;   //页容量

    public static PageUtil pageUtil(int code, String msg, IPage page){
        PageUtil r=new PageUtil()
                .setCode(code)
                .setMsg(msg)
                .setData(page.getRecords())
                .setCurrent(page.getCurrent())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setPages(page.getPages());
        return r;
    }

    public static PageUtil succ(IPage object){
        return pageUtil(200,"操作成功",object);
    }
    public static PageUtil fail(String msg){
        return pageUtil(400,msg,null);
    }
}
