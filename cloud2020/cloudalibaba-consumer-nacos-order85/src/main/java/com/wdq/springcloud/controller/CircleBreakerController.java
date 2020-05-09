package com.wdq.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wdq.springcloud.Service.PaymentService;
import com.wdq.springcloud.entities.CommonResult;
import com.wdq.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 10:26
 * @Description:
 */
@RestController
public class CircleBreakerController {

    //public static final  String SERVICE_URL = "http://nacos-payment-provider";
    @Value("${server-url.nacos-user-service}")
    public String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//没有配置
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")//blockHandler只负责sentinel控制台配置违规
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback")//blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback",
            exceptionsToIgnore = IllegalArgumentException.class)//忽略IllegalArgumentException异常
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class,id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        }else if(result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return  result;
    }
    //本例是fallback
    public CommonResult handlerFallback(@PathVariable Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(444,"异常handlerFallback，exception内容： " + e.getMessage(), payment);
    }

    //本例是blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(555,"异常handlerFallback，exception内容： " + blockException.getMessage(), payment);
    }

    //====OpenFeign=====
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
