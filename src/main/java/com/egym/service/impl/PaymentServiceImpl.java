package com.egym.service.impl;

import com.egym.dao.PaymentDao;
import com.egym.model.Payment;
import com.egym.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MichaelMAC on 12.01.17.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public void addPayment(Payment payment) {
        paymentDao.addPayment(payment);
    }
}
