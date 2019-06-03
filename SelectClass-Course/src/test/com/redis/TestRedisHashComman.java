package com.redis;

import com.model.User;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 测试hash类型的操作
 * @date 2019/5/28 15:24
 */
public class TestRedisHashComman {
    JedisPool pool;
    Jedis jedis;

    @Before
    public void setUp(){
        jedis=new Jedis("127.0.0.1",6379);
    }

    /**
     * jedis操作map通过hash
     */
    @Test
    public void test1(){
//        User user1=new User(1,"用户1","12345");
//        Map<String, String> user=new HashMap<>();
//        user.put("name",user1.getUsername());
//        user.put("psd",user1.getPassword());
//        jedis.hmset("user",user);

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while(iter.hasNext()){
            String key=iter.next();
            System.out.println(key+" "+jedis.hget("user",key));
        }

    }

}
