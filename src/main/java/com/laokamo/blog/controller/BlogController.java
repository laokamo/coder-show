package com.laokamo.blog.controller;

import com.laokamo.blog.entity.es.EsBlog;
import com.laokamo.blog.service.EsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 博客controller
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {


    @Autowired
    private EsBlogService esBlogService;

    /**
     * 查询blog
     * @param title
     * @param summary
     * @param content
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title")String title,
                             @RequestParam(value = "summary")String summary,
                             @RequestParam(value = "content")String content,
                             @RequestParam(value = "pageIndex",defaultValue = "0")int  pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "10")int  pageSize){
        PageRequest pageRequest = PageRequest.of(pageIndex,pageSize);
        Page<EsBlog> blog = esBlogService.findBlogs(title, summary, content, pageRequest);
        return blog.getContent();
    }

}
