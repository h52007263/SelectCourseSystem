package com.redis;

import com.hzs.utils.RedisUtil;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hezhensheng
 * @version 1.0
 * @description redis整合spring的测试
 * @date 2019/5/28 18:29
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringRedis {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        RedisUtil redisUtil=(RedisUtil) context.getBean("redisUtil");

        System.out.println(redisUtil);


    }
}
