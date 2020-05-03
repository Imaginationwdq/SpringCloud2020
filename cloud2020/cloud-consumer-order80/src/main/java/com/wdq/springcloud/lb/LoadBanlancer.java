package com.wdq.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Auther: wdq
 * @Date: 2020/5/3 11:11
 * @Description:
 */
public interface LoadBanlancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
