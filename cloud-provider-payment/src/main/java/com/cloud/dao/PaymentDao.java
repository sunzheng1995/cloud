package com.cloud.dao;

import com.cloud.model.Payment;

public interface PaymentDao {
    int create(Payment payment);

    Payment getById(long id);
}
