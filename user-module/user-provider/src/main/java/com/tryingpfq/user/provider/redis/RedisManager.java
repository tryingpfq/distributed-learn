package com.tryingpfq.user.provider.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author tryingpfq
 * @Date 2020/4/8
 */
public class RedisManager {
    private static JedisPool jedisPool;

    static{
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(20);
        poolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(poolConfig, JedisProperties.HOST, 6379);
    }

    public static Jedis getJedis() throws Exception {
        if (jedisPool != null) {
            return jedisPool.getResource();
        }
        throw new Exception("jedisPool is null");
    }
}
