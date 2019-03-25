package com.laokamo.blog.service;

import com.laokamo.blog.entity.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EsBlogService {

    Page<EsBlog> findBlogs(String title, String summary, String content, Pageable pageable);
}


