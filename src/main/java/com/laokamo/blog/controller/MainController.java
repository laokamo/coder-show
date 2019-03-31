package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-28 21:27
 * @description：
 * @version: 1.0.0
 */
@Controller
public class MainController {


    @GetMapping("/")
    public String hello(){
        return "index";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }
}
