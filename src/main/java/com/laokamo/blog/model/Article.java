package com.example.blog.model;

import lombok.Data;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 15:02
 * @description：
 * @version: 1.0.0
 */
@Data
public class Article {

    private Long id;

    private String author;

    private String title;

    private String content;

    private String htmlContent;

    private int click;

    private int type; //1 可见 0 不可见

    private String createTime;

    private String updateTime;
}
