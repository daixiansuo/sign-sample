package com.dxs.server.redis;

import com.dxs.server.redis.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author D丶Cheng
 * @Created with IntelliJ IDEA.
 * @date: 2018/7/4
 *
 */

@Component
public class TokenRedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * 这里的bandou_common:app:要注意替换成项目名，例如tokenUp:app:
     */
    private final String APP_TOKEN_PREFIX = "ProjectPlatform:api:";


    public void saveToken(String userId, String token) {

        redisTemplate.opsForValue().set(APP_TOKEN_PREFIX + userId, token);
        redisTemplate.expire(APP_TOKEN_PREFIX + userId, RedisConstant.APP_TOKEN_EXPIRE_TIME, TimeUnit.SECONDS);

    }


    public void removeToken(String userId) {

        redisTemplate.delete(APP_TOKEN_PREFIX + userId);

    }

    public boolean checkToken(String userId, String token) {
        String originToken = redisTemplate.opsForValue().get(APP_TOKEN_PREFIX + userId);

        if (originToken != null && originToken.equals(token))
            return true;
        return false;

    }


}
