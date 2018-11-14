package com.dxs.server.controller;

import com.dxs.server.annotation.Authorization;
import com.dxs.server.constant.APIConstant;
import com.dxs.server.redis.TokenRedisDao;
import com.dxs.server.utils.JWTUtils;
import com.dxs.server.utils.result.Result;
import com.dxs.server.utils.result.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.Dxs on 2018/11/14.
 */
@RestController
@RequestMapping("/user")
public class DemoController {


    @Autowired
    private TokenRedisDao tokenRedisDao;


    /**
     * 登录   登录成功返回 token
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public Result login(@RequestParam(required = true, defaultValue = "", value = "username") String username,
                        @RequestParam(required = true, defaultValue = "", value = "password") String password){


        /**
         * 此处生成 token
         * 在此为测试，所以只是简单生成。
         */
        Map domain = new HashMap();
        domain.put("username",username);
        domain.put("time", System.currentTimeMillis());
        String token = JWTUtils.generateToken(APIConstant.USER_JWT_PREFIX, domain);


        /**
         * 持久化到 Redis
         * 此处使用 username  是为了方便退出接口删除。
         */
        tokenRedisDao.saveToken(username, token);


        Map resultMap = new HashMap();
        resultMap.put("username",username);
        resultMap.put("token", token);

        return new ResultBuilder<>().setData(resultMap).build();
    }


    /**
     * Authorization 注解  表示请求该接口 需要登录权限
     * @param username
     * @return
     */
    @RequestMapping(value = "/logout.action", method = RequestMethod.POST)
    @Authorization
    public Result info(@RequestParam(required = true, defaultValue = "", value = "username") String username){

        // 删除 token
        tokenRedisDao.removeToken(username);

        return new ResultBuilder<>().setMsg("token delete success").build();

    }

}
