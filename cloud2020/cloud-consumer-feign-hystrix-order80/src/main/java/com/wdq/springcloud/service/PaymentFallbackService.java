package com.wdq.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Auther: wdq
 * @Date: 2020/5/5 13:56
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_Timeout,/(ㄒoㄒ)/~~";
    }
}
