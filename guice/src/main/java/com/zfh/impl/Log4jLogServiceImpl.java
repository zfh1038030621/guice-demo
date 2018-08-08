package com.zfh.impl;

import com.google.inject.Singleton;
import com.zfh.inter.LogService;
//默认情况下Guice会在每次注入的时候创建一个新对象。（多例）
// 如果希望创建一个单例依赖的话，可以在实现类上应用@Singleton注解。
@Singleton
public class Log4jLogServiceImpl implements LogService {
    public void loginfo() {
        System.out.println("Log4j 日志打印");
    }
}
