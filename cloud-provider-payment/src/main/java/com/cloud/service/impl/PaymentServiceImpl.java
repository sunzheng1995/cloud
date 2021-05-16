package com.cloud.service.impl;

import com.cloud.dao.PaymentDao;
import com.cloud.model.Payment;
import com.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Transactional
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getById(long id) {
        return paymentDao.getById(id);
    }
}
