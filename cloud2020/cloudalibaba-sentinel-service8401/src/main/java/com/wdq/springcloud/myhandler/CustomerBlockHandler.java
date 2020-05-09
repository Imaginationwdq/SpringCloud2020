package com.wdq.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wdq.springcloud.entities.CommonResult;
import com.wdq.springcloud.entities.Payment;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 10:03
 * @Description:
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义的Glogal 全局异常处理 ---- 1",new Payment(2020L,"serial003"));
    }

    public static CommonResult handlerException2(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义的Glogal 全局异常处理 ---- 2",new Payment(2020L,"serial003"));
    }
}