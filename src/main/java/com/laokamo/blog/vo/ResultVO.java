package com.example.blog.vo;

import lombok.Data;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 15:16
 * @description：
 * @version: 1.0.0
 */
@Data
public class ResultVO<T> {

    private int code;

    private String msg;

    private T data;


}
