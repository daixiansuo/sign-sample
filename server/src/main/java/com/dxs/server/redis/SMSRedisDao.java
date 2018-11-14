package com.dxs.server.redis;

import com.dxs.server.redis.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: D丶Cheng
 * @Description:
 * @Date: 2018/7/5 下午3:07
 */

@Component
public class SMSRedisDao {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    private final String SMS_CODE_PREFIX = "sms:";

    public void saveCode(String scope, String phone, String code){

        String key = getKey(scope, phone);
        redisTemplate.opsForValue().set(key, code);

        redisTemplate.expire(key, RedisConstant.SMS_CODE_EXPIRE_TIME, TimeUnit.SECONDS);

    }

    public String getCode(String scope, String phone){
        String key = getKey(scope, phone);
        return redisTemplate.opsForValue().get(key);

    }

    public void removeCode(String scope, String phone){
        String key = getKey(scope, phone);
        redisTemplate.delete(key);
    }



    String getKey( String scope, String phone){
         return SMS_CODE_PREFIX + scope + ":" + phone;
    }


}
