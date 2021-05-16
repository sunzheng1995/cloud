package com.cloud.service;

import com.cloud.model.Payment;

public interface PaymentService {
    Payment getById(long id);
}
