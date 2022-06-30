package com.owl.connect;

import redis.clients.jedis.Jedis;

public class RedisJava {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connected...");
        System.out.println("Server is run... " + jedis.ping());
    }

}
