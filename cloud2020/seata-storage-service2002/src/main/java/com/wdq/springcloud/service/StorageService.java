package com.wdq.springcloud.service;

/**
 * @Auther: wdq
 * @Date: 2020/5/9 16:05
 * @Description:
 */

public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}