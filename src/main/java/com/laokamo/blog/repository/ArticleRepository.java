package com.laokamo.blog.repository;

import com.laokamo.blog.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleRepository {

    void insert(Article article);

    Article selectArticleById(Long id);

    List<Article> selectAll();
}
