package com.wdq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: wdq
 * @Date: 2020/5/2 21:05
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8003 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8003.class,args);
    }
}