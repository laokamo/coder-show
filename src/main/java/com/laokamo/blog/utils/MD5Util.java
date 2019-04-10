package com.laokamo.blog.utils;

import org.springframework.util.DigestUtils;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-29 10:44
 * @description：
 * @version: 1.0.0
 */
public class MD5Util {

    public static String encode(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
