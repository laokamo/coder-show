package com.laokamo.blog.controller;

import com.laokamo.blog.model.Article;
import com.laokamo.blog.service.ArticleService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 16:15
 * @description：
 * @version: 1.0.0
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/article/{id}")
    public String article(@PathVariable Long id , Model model){
        Article article = articleService.findArticleById(id);
        model.addAttribute("article",article);
        return "article";
    }


    /**
     * 分页查询文章
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/articles")
    @ResponseBody
    public JSONArray articles(@RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(value = "size", defaultValue = "5") Integer size){
        JSONArray allArticle = articleService.findAllArticle(page, size);
        return allArticle;
    }

}
