package com.xiaow.ssmdemo.model;

import lombok.*;

import java.sql.Date;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientBean {

    private Integer id;
    private String name;
    private String sex;
    private String idcard;
    private String outt;

    private int nid;
    private int uid;
    private int pid;
    private int age;
    private double money;
    private Date ctime;
    private String identification;
    private String username;

}
