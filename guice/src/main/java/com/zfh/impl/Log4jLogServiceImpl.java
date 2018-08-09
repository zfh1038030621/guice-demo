package com.zfh.impl;

import com.zfh.inter.LogService;

public class Log4jLogServiceImpl implements LogService {
    @Override
    public void loginfo() {
        System.out.println("log4j");
    }
}
