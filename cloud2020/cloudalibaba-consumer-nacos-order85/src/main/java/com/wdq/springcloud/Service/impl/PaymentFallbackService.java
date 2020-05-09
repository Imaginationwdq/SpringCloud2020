package com.wdq.springcloud.Service.impl;

import com.wdq.springcloud.Service.PaymentService;
import com.wdq.springcloud.entities.CommonResult;
import com.wdq.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 11:09
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，--PaymentFallbackService",new Payment(id,"error"));
    }
}
