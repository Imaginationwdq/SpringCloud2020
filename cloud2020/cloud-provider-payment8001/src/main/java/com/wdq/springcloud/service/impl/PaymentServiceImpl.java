package com.wdq.springcloud.service.impl;

import com.wdq.springcloud.dao.PaymentDao;
import com.wdq.springcloud.entities.Payment;
import com.wdq.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: wdq
 * @Date: 2020/5/1 11:50
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
