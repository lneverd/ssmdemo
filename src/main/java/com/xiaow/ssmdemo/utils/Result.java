package com.xiaow.ssmdemo.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Result implements Serializable {
    private int code;     //200 正常 非200 不正常
    private String msg;
    private Object data;
    /**
     * 1: 单个对象
     * 2：列表
     * 3：分页列表
     * **/
    private Integer type=1;

    public static Result result(int code,String msg,Object object){
        Result r=new Result()
                .setCode(code)
                .setMsg(msg)
                .setData(object);
        return r;
    }
    public static Result result(int code,String msg,Object object,Integer type){
        Result r=new Result()
                .setCode(code)
                .setMsg(msg)
                .setData(object)
                .setType(type);
        return r;
    }

    public static Result succ(Object object){
        return result(200,"操作成功",object);
    }
    public static Result succ(Object object,Integer type){
        return result(200,"操作成功",object,type);
    }
    public static Result fail(String msg){
        return result(400,msg,"");
    }
}
