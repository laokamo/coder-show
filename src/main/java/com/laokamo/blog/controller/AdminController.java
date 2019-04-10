package com.laokamo.blog.controller;

import com.laokamo.blog.model.Article;
import com.laokamo.blog.service.ArticleService;
import com.laokamo.blog.utils.ArticleTabloidUtil;
import com.laokamo.blog.utils.ResultResponse;
import com.laokamo.blog.utils.TimeUtils;
import com.laokamo.blog.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 07:48
 * @description：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("admin")
@Slf4j
public class AdminController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("blogs")
    public String blogs(){
        return "admin/blogs";
    }


    @GetMapping("blog")
    public String blog(){
        return "admin/blog";
    }

    @PostMapping("save")
    @ResponseBody
    public ResultVO articleContent(@RequestBody Article article,
                                   @AuthenticationPrincipal Principal principal) {
        String username = null;
        try {
            username = principal.getName();
        } catch (NullPointerException e){
            log.error("用户未登陆");
        }

        String tabloid = ArticleTabloidUtil.buildArticleTabloid(article.getHtmlContent());

        String formatDateForSix = TimeUtils.getFormatDateForSix();
        article.setAuthor(username);
        article.setHtmlContent(tabloid);
        article.setType(0);
        article.setClick(0);
        article.setCreateTime(formatDateForSix);
        article.setUpdateTime(formatDateForSix);
        articleService.save(article);

        return ResultResponse.success();
    }


}
