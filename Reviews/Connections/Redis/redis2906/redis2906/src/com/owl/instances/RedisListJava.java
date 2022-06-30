package com.owl.instances;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connection to server sucessfully");
        jedis.lpush("list", "Redis");
        jedis.lpush("list", "Mongodb");
        jedis.lpush("list", "Mysql");
        List<String> list = jedis.lrange("list", 0, 1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis::" + list.get(i));
        }
    }
}
