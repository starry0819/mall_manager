package com.atguigu.test;

import redis.clients.jedis.Jedis;

public class JedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.2.128", 6379);
		System.out.println(jedis);
	}
}
