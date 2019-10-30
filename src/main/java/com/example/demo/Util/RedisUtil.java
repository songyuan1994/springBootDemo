package com.example.demo.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    static Logger logger = LoggerFactory.getLogger(RedisUtil.class);


    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "0";
        } finally {
            if (jedis != null) jedisPool.returnResourceObject(jedis);
        }
    }

}
