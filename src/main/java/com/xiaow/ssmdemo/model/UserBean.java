package com.xiaow.ssmdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author xiaow
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserBean implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String introduce;
    private String level1;
    private String avatar;
}
