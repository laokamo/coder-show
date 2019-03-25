package com.laokamo.blog.service.impl;

import com.laokamo.blog.dao.es.EsBlogRepository;
import com.laokamo.blog.entity.es.EsBlog;
import com.laokamo.blog.service.EsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EsBlogServiceImpl implements EsBlogService {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Override
    public Page<EsBlog> findBlogs(String title, String summary, String content, Pageable pageable) {
        return esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
    }

}
