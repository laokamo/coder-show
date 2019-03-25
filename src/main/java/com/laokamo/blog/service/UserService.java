package com.laokamo.blog.service;

import com.laokamo.blog.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 新增或修改用户
     * @param user
     * @return
     */
    User saveOrUpdate(User user);


    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);


    /**
     * 查询用户
     * @param id
     * @return
     */
    User getUserById(Long id);


    /**
     * 获取用户列表
     * @return
     */
    List<User> listUser();
}
