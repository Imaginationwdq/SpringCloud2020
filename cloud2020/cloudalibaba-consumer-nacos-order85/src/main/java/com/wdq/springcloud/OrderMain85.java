package com.wdq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 10:25
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain85 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain85 .class,args);
    }
}
