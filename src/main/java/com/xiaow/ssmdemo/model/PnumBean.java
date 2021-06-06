package com.xiaow.ssmdemo.model;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PnumBean {

    private Integer id;
    private int uid;
    private int pid;
    private Integer age;
    private Double money;
    private Date ctime;
    private String identification;

}
