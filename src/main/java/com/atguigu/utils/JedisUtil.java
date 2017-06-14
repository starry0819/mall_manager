package com.atguigu.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static JedisPoolConfig config = new JedisPoolConfig();	//连接池配置
	private static JedisPool pool = null;	//连接池对象
	static{
		config.setBlockWhenExhausted(false); // 连接耗尽则阻塞
		config.setLifo(true); // 后进先出
		config.setMaxIdle(10); // 最大空闲连接数为10
		config.setMinIdle(0); // 最小空闲连接数为0
		config.setMaxTotal(100); // 最大连接数为100
		config.setMaxWaitMillis(-1); // 设置最大等待毫秒数：无限制
		config.setMinEvictableIdleTimeMillis(180); // 逐出连接的最小空闲时间：30分钟
		config.setTestOnBorrow(true); // 获取连接时是否检查连接的有效性：是
		config.setTestWhileIdle(true); // 空闲时是否检查连接的有效性：是

		pool = new JedisPool(config, "192.168.2.128", 6379); // 初始化连接池
	}
	
	public static Jedis getJedisResource(){
		return pool.getResource();
	}
}
