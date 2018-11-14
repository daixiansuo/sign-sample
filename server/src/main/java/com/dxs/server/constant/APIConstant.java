package com.dxs.server.constant;


/**
 * @author Mr.Dxs
 * @Created with IntelliJ IDEA.
 * @date: 2018/7/4
 * @time: 15:58
 * @Description: 常量池
 */
public class APIConstant {

    // Header 中 token 的 key
    public final static String AUTHORIZATION = "Authorization";

    // JWTUtil Redis 数据库 用户 key 前缀
    public static String USER_JWT_PREFIX = "api:jwt:";

    // Header 中 sign 的 key
    public static final String HEADER_ENCRYPTE_SIGN = "Encrypt-Sign";

    // 该项目签名 sign-key
    public static final String SIGN_KEY = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";



}
