package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @author hezhensheng
 * @version 1.0
 * @description hash类型的学习
 * @date 2019/5/28 15:21
 */

public class Demo1 {
    public static void main(String[] args) {

        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("a","bar");
        String value=jedis.get("a");
        System.out.println(value);

    }
}
