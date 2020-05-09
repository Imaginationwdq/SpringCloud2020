package com.wdq.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Auther: wdq
 * @Date: 2020/5/8 18:26
 * @Description:
 */
@Service
public class TestC {

    @SentinelResource("testC")
    public String testC(){
        return "--testc";
    }
}
