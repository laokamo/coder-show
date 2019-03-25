package com.laokamo.blog.controller;

import com.laokamo.blog.entity.User;
import com.laokamo.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 从 用户存储库 获取用户列表
     * @return
     */
    private List<User> getUserList() {
        return userService.listUser();
    }

    /**
     * 展示用户列表页面
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("title","用户管理");
        model.addAttribute("userList",getUserList());
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable Long id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取新增/修改用户表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView createUser(User user){
        userService.saveOrUpdate(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 根据id删除相应的用户数据
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id,Model model){
        userService.deleteUser(id);
        model.addAttribute("userList", getUserList());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 修改用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable Long id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}
