package com.wdq.springcloud.controller;

import com.wdq.springcloud.domain.CommonResult;
import com.wdq.springcloud.domain.Order;
import com.wdq.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 16:08
 * @Description:
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}

