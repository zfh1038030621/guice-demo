package com.zfh.impl;

import com.zfh.inter.LogService;

public class Slf4jLogServiceImpl implements LogService {
    @Override
    public void loginfo() {
        System.out.println("Slf4j");
    }
}
