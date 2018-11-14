package com.dxs.server.aop;

import com.dxs.server.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by D丶Cheng on 2018/7/4.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    //切入点
    @Pointcut("execution(public * com.dxs.server.controller.*.*(..))")
    private void auth() {

    }

    @Before("auth()")
    private void before(JoinPoint joinPoint) throws Exception {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("--------------------------------------------start----------------------------------------------");
        // url
        logger.info("URL = {} ", request.getRequestURL());
        // method
        logger.info("METHOD = {}", request.getMethod());
        // ip
        logger.info("IP = {}", getIp(request));
        // 类名 、 类方法
        logger.info("ClASS_METHOD = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 参数
        logger.info("ARGS = {}", showParamter(request.getParameterMap()));
        // 时间
        logger.info("DATE = {}",DateUtil.parseDate(new Date()));

        logger.info("---------------------------------------------end----------------------------------------------");
    }


    public String showParamter(Map<String, String[]> map) {
        String result = "";
        for (String key : map.keySet()) {
            result += key + ":" + String.valueOf(map.get(key)[0]) + " ";
        }
        return result;
    }

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }

}