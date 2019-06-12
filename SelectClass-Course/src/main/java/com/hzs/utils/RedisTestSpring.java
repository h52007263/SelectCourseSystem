package com.hzs.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description spring下的redis测试
 * @date 2019/5/28 18:39
 */
public class RedisTestSpring {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","hzs");
//        map.put("pwd","123");
//        redisUtil.hmset("admin",map);
        System.out.println(redisUtil.hget("user","pwd"));
    }
}
