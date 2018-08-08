package com.zfh.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ������
 * guice���aop���ܵ�ʵ����Ҫ��aopalliance jar
 * @author zfh
 * @since 2018/08/08
 */
public class LoggerAop implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String methodName = methodInvocation.getMethod().getName();
        System.out.println("��log��"+methodName+"����ִ��");

        Object ret = null;
        try{
            ret = methodInvocation.proceed();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
