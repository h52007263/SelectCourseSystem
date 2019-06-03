package com.redis;

import com.hzs.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhensheng
 * @version 1.0
 * @description spring下的redis测试
 * @date 2019/5/28 18:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisTestSpring {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test1(){
        System.out.println(redisTemplate);
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","hzs");
//        map.put("pwd","123");
//        redisUtil.hmset("admin",map);
//        System.out.println(redisUtil.hget("admin","pwd"));
    }
}
