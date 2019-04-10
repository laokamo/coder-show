package com.laokamo.blog.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：laokamo
 * @date ：Created in 2019-03-30 11:04
 * @description：
 * @version: 1.0.0
 */
public class TimeUtils {

    /**
     * 格式化日期
     * 使用线程安全的DateTimeFormatter
     * @return “年-月-日 时:分:秒”字符串
     */
    public static String getFormatDateForSix(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(format);
    }
}
