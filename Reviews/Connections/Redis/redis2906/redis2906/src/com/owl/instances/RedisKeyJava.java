package com.owl.instances;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisKeyJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connection to server sucessfully");
        List<String> list = (List<String>) jedis.keys("*");
        for (int i = 0; i < list.size(); i ++ ){
            System.out.println("List of stored keys:: "+list.get(i));
        }
    }
}
