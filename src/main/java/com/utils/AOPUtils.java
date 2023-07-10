package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dynamodb.dao.impl.UserDaoImpl;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Slf4j
@Component
public class AOPUtils {
    private  final Logger logger = LoggerFactory.getLogger(AOPUtils.class);

    @Pointcut("execution(* com.*.controller.*.*(..))")
    public void aopMethod(){

    }
    @Around("aopMethod()")
    public void doApiArround(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        //获取方法名和类名
        Signature signature = proceedingJoinPoint.getSignature();
        //请求参数
        Object arg = args[0];
        try {
            logger.info("API请求:"+signature.getDeclaringTypeName()+"类,方法:"
                    +signature.getName()+"请求参数为:"+ JSON.toJSONString(arg));
            Object proceed = proceedingJoinPoint.proceed();
            logger.info("API返回:"+signature.getDeclaringTypeName()+"类,方法:"
                    +signature.getName()+"返回参数为:"+(ResponseUtils)proceed);
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {

        }
    }
}
