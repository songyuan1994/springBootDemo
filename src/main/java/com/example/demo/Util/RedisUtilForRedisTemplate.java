package com.example.demo.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Tuple;

import java.util.Set;
import java.util.concurrent.TimeUnit;
@Component
public class RedisUtilForRedisTemplate {
    //使用redisTemplate操作redis
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    static Logger logger = LoggerFactory.getLogger(RedisUtilForRedisTemplate.class);


/*    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }*/
    //=============================common============================
    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String ... key){
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    //============================String=============================
    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key, int indexdb){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key,String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean setForExpire(String key,String value,long time){
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else{
                redisTemplate.opsForValue().set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * zadd
     * @param dialogKey key
     * @param score 分数
     * @param dialogstr 值
     * @return true成功 false 失败
     */
    public Boolean BoxZAdd(String dialogKey, double score, String dialogstr){
        try {
            return redisTemplate.opsForZSet().add(dialogKey, dialogstr, score);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Set<ZSetOperations.TypedTuple<Object>> redisZRevrange(String dialogKey, long start, long end) {
        try {
            Set<ZSetOperations.TypedTuple<Object>> dialogSet = redisTemplate.opsForZSet().reverseRangeWithScores(dialogKey, start, end); //pagination
            return dialogSet;
        } catch (Exception e) {
            logger.error("fail to read redis: dialogKey='{}'", dialogKey);
            logger.error(e.getMessage(), e);
        }
        return null;
    }

}
