package com.example.blog.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 11:00
 * @description：
 * @version: 1.0.0
 */
@Data
public class Role implements Serializable {

    private Long roleId;

    private String name;
}
