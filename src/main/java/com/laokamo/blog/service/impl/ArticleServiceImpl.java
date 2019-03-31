package com.example.blog.service.impl;

import com.example.blog.model.Article;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 15:38
 * @description：
 * @version: 1.0.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Transactional
    public void save(Article article) {
        articleRepository.insert(article);
    }

    @Override
    public Article findArticleById(Long id) {
        return articleRepository.selectArticleById(id);
    }

    @Override
    public JSONArray findAllArticle(Integer page, Integer size) {

        PageHelper.startPage(page,size);
        List<Article> articles = articleRepository.selectAll();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);

        List<Map<String, Object>> newArticles = new ArrayList<>();
        Map<String, Object> map;

        for(Article article : articles){
            map = new HashMap<>();
            map.put("thisArticleUrl", "/article/" + article.getId());
            map.put("articleTitle", article.getTitle());
            map.put("publishDate", article.getCreateTime());
            map.put("originalAuthor", article.getAuthor());
            map.put("articleTabloid", article.getHtmlContent());
            map.put("click", article.getClick());
            newArticles.add(map);
        }
        JSONArray jsonArray = JSONArray.fromObject(newArticles);
        Map<String, Object> thisPageInfo = new HashMap<>();
        thisPageInfo.put("pageNum",pageInfo.getPageNum());
        thisPageInfo.put("pageSize",pageInfo.getPageSize());
        thisPageInfo.put("total",pageInfo.getTotal());
        thisPageInfo.put("pages",pageInfo.getPages());
        thisPageInfo.put("isFirstPage",pageInfo.isIsFirstPage());
        thisPageInfo.put("isLastPage",pageInfo.isIsLastPage());

        jsonArray.add(thisPageInfo);
        return jsonArray;


    }
}
