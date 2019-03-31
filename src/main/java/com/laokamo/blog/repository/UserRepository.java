package com.example.blog.repository;

import com.example.blog.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    /**
     * 通过邮箱查找用户
     * @param email 邮箱
     * @return 用户
     */
    User findUserByEmail(String email);
}
