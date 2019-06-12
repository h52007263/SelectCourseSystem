package com.redis;

import com.hzs.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author hezhensheng
 * @version 1.0
 * @description redis整合spring的测试
 * @date 2019/5/28 18:29
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringRedis {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){

//        Map<String,Object> map=new HashMap<>();
//        map.put("courseId","1");
//        map.put("teacherId","1001");
//        map.put("courseName","数据结构");
//        map.put("courseProperty","专业必修");
//        map.put("hour","64");
//        map.put("credit","4");
//        map.put("capacity","200");
//        map.put("grade","2016");
//        map.put("major","软件工程");
//        redisUtil.hmset("course"+map.get("courseId"),map);
//        System.out.println("存储成功");

        Map<Object,Object> course1 = redisUtil.hmget("course1");
        Set<Object> courseKeys=course1.keySet();
        Iterator iter = (Iterator) courseKeys.iterator();
        while(iter.hasNext()){
            Object key = iter.next();
            Object val = course1.get(key);
            System.out.println(key+"  "+val);
        }

    }

}
