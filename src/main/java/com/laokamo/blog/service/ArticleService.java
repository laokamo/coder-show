package com.laokamo.blog.service;

import com.laokamo.blog.model.Article;
import net.sf.json.JSONArray;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 15:37
 * @description：
 * @version: 1.0.0
 */
public interface ArticleService {

    void save(Article article);

    Article findArticleById(Long id);

    JSONArray findAllArticle(Integer page, Integer size);
}
