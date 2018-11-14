package com.dxs.server.utils;


import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * The type Encrypt utils.
 * 盐值 工具类
 */
public class EncryptUtils {


    /**
     * Encrypt string.
     *
     * @param target
     * @param salt     the salt
     * @return the string
     */
    public static String encrypt(String target, String salt){
        String algorithmName = "SHA-512";
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash(algorithmName, target, salt, hashIterations);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }

    /**
     * Create salt string.
     *
     * @return the string
     */
    public static String createSalt(){
        return new SecureRandomNumberGenerator().nextBytes().toHex();
    }


}
