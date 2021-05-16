package com.cloud.service;

import com.cloud.model.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getById(long id);
}
