package com.zfh.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author  zfh
 */
public class LoggerAop implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String methodName = methodInvocation.getMethod().getName();
        System.out.println("【log】"+methodName+"执行了");

        Object ret = null;
        try{
            ret = methodInvocation.proceed();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
