package com.owl.instances;

import redis.clients.jedis.Jedis;

public class RedisStringJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connection to server sucessfully");
        jedis.set("Felipe", "Study REDIS");
        System.out.println("Stored string in redis:: " + jedis.get("Felipe"));
    }
}
