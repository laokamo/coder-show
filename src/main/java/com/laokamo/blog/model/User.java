package com.example.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 10:58
 * @description：
 * @version: 1.0.0
 */
@Data
public class User implements Serializable {

    private Long userId;

    private String username;

    private String email;

    private String password;

    private int sex;

    private String telephone;

    private List<Role> roles;

}
