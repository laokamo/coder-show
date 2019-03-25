package com.laokamo.blog.dao;

import com.laokamo.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户接口
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
