package com.wdq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wdq.springcloud.service.TestC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wdq
 * @Date: 2020/5/8 13:52
 * @Description:
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Resource
    private TestC testC;

    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName()+"\t"+"testA");
        return "----testA"+testC.testC();
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"\t"+"testB");
        return "----testB"+testC.testC();
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "----testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value ="p1",required = false)  String p1,
                             @RequestParam(value ="p2",required = false)  String p2){
        return "----testHotKey";
    }

    /**
     * 兜底方法
     * @param p1
     * @param p2
     * @param blockHandler
     * @return
     */
    public String deal_testHotKey(String p1, String p2, BlockException blockHandler){
        return "----deal_testHotKey/(ㄒoㄒ)/~~";
    }
}
