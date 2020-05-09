package com.wdq.springcloud.Service;

import com.wdq.springcloud.Service.impl.PaymentFallbackService;
import com.wdq.springcloud.entities.CommonResult;
import com.wdq.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 11:06
 * @Description:
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
