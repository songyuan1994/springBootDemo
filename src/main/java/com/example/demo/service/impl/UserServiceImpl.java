package com.example.demo.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Util.RedisUtil;
import com.example.demo.Util.RedisUtilForRedisTemplate;
import com.example.demo.common.ResultError;
import com.example.demo.common.ResultObject;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final static int readWriteMemcachedTimeOut = 3 * 1000; //3秒

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisUtilForRedisTemplate redisUtilForRedisTemplate;


    @Override
    public String getUserById(String userId) {
        User user = userDao.getUserById(userId);

        return ResultObject.toResult(ResultError.SUCCESS, user);
    }

    @Override
    public String testRedisSet(String userId) {
        redisUtil.set("testKey",userId);
        return ResultObject.toResult(ResultError.SUCCESS, null);
    }

    @Override
    public String testRedisTemplateAdd(String userId) {
        redisUtilForRedisTemplate.set("testRedisTemplate",userId);
        User user = new User();
        user.setUserId("22_1");
        user.setMobile("15603711179");
        user.setNickName("宋源");
        redisUtilForRedisTemplate.set("testRedisTemplate2", JSONObject.toJSONString(user));
        return ResultObject.toResult(ResultError.SUCCESS, null);
    }

    @Override
    public String testZAdd(String userId) {
        User user = new User();
        user.setUserId("1_1");
        user.setMobile("15603711171");
        user.setNickName("宋源");
        redisUtilForRedisTemplate.BoxZAdd("user_zrange",(double) 100,JSONObject.toJSONString(user));

        User user2 = new User();
        user2.setUserId("2_1");
        user2.setMobile("15603711172");
        user2.setNickName("宋源2");
        redisUtilForRedisTemplate.BoxZAdd("user_zrange",(double) 200,JSONObject.toJSONString(user2));

        return ResultObject.toResult(ResultError.SUCCESS, null);
    }

    @Override
    public String testZReverseRange(String userId) {
        Set<ZSetOperations.TypedTuple<Object>> userSet = redisUtilForRedisTemplate.redisZRevrange("user_zrange",0,-1);
        List<User> resultList = new ArrayList<>();
        for(ZSetOperations.TypedTuple<Object> tuple : userSet){
           User user = JSONObject.parseObject(String.valueOf(tuple.getValue()),User.class);
           System.out.println("Score ="+tuple.getScore());
           resultList.add(user);
        }
        return ResultObject.toResult(ResultError.SUCCESS, resultList);
    }

}
