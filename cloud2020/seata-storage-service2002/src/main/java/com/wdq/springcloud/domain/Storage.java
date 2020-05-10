package com.wdq.springcloud.domain;

import lombok.Data;


/**
 * @Auther: wdq
 * @Date: 2020/5/9 16:00
 * @Description:
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
