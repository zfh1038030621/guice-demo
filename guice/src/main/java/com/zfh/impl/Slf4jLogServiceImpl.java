package com.zfh.impl;

import com.google.inject.Singleton;
import com.zfh.inter.LogService;
//Ĭ�������Guice����ÿ��ע���ʱ�򴴽�һ���¶��󡣣�������
// ���ϣ������һ�����������Ļ���������ʵ������Ӧ��@Singletonע�⡣
@Singleton
public class Slf4jLogServiceImpl implements LogService {
    public void loginfo() {
        System.out.println("Slf4j ��־��ӡ");
    }
}
