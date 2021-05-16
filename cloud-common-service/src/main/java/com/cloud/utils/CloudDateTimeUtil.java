package com.cloud.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 */
public class CloudDateTimeUtil {
    public static final String FORMAT_ALL = "yyyy-MM-dd HH:mm:ss";


    /**
     * 获取当前时间
     *
     * @param format 格式化模板
     * @return 时间字符串
     */
    public static String getNow(String format) {
        if (format == null) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = dateTimeFormatter.format(LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
