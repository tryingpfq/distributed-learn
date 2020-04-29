package com.tryingpfq.user.provider.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tryingpfq
 * @Date 2020/4/8
 */
public class LuaUse {
    //当然我们一般是从文件去加载
    public static final String SCRIPT_STR = "local num=redis.call('incr',KEYS[1])\n" +
            "if tonumber(num)==1 then\n" +
            "    redis.call('expire',KEYS[1],ARGV[1])\n" +
            "    return 1\n" +
            "elseif tonumber(num)>tonumber(ARGV[2]) then\n" +
            "    return 0\n" +
            "else\n" +
            "    return 1\n" +
            "end";

    public static void main(String[] args) throws Exception {
        Jedis jedis = RedisManager.getJedis();
        List<String> keys = new ArrayList<>();
        keys.add("ip:limit:192.168.146.128");
        List<String> argvs = new ArrayList<>();
        argvs.add("6000");
        argvs.add("10");
        Object o = jedis.evalsha(jedis.scriptLoad(SCRIPT_STR), keys, argvs);
        System.err.println(o);
    }

}
