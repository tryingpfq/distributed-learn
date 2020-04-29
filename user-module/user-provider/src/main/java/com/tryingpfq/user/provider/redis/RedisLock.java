package com.tryingpfq.user.provider.redis;

import org.springframework.orm.jpa.vendor.OpenJpaDialect;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisMonitor;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * @Author tryingpfq
 * @Date 2020/4/8
 */
public class RedisLock {
    private String lockValue;

    public String getLock(String key, int tryTimeOut, int expire) {
        try {
            Jedis jedis = RedisManager.getJedis();
            String uuid = UUID.randomUUID().toString();
            long endTime = System.currentTimeMillis() + tryTimeOut;
            while (System.currentTimeMillis() < endTime) {
                if (jedis.setnx(key, uuid) == 1) {//这个地方不是阻塞的 所以要只是延迟请求时间
                    //设置超时时间
                    jedis.expire(key, expire);
                    this.lockValue = uuid;
                    return lockValue;
                }
                //防止在设置超时时间前，连接挂了
                if (jedis.ttl(key) < 0) {
                    jedis.expire(key, expire);
                }
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean releaseLock(String key, String lockValue) {
        try {
            Jedis jedis = RedisManager.getJedis();
            while (true) {
                jedis.watch(key);
                if (lockValue.equals(jedis.get(key))) {
                    Transaction transaction = jedis.multi();
                    transaction.del(key);
                    List<Object> list = transaction.exec();
                    if (list == null) {
                        continue;
                    }
                    return true;
                }
                jedis.unwatch();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        RedisLock redisLock = new RedisLock();
        String key = "lock:one";
        String lock = redisLock.getLock(key, 2000, 10);
        if (lock != null) {
            System.err.println("lock success :" + lock);
        }
        String lock2 = redisLock.getLock(key, 1000, 10);
        if (lock2 == null) {
            System.err.println("second get fail");
        }
        Thread.sleep(3);
       // redisLock.releaseLock(key, lock);
    }
}
