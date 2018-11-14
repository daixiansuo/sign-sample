package com.dxs.server.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author D丶Cheng
 * @date: 2018/7/4
 * @time: 16:44
 * @description: 验证码redis工具类
 */
@Component
public class CodeRedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;


    private final String USER_CODE_REDIS_PREFIX = "userCode:";

    public void saveUserCode(Integer type, String phone, String code) {
        redisTemplate.opsForValue().set(getUserCodeKey(type, phone), code, 15, TimeUnit.MINUTES);
    }

    public String getUserCode(Integer type, String phone) {
        return redisTemplate.opsForValue().get(getUserCodeKey(type, phone));
    }

    private String getUserCodeKey(Integer type, String phone) {
        return type + USER_CODE_REDIS_PREFIX + phone;
    }

    public void removeUserCode(Integer type, String phone) {
        redisTemplate.delete(getUserCodeKey(type, phone));
    }


}
