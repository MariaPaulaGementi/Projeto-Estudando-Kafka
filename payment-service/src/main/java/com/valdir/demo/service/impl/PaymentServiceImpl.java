package com.valdir.demo.service.impl;

import com.valdir.demo.model.Payment;
import com.valdir.demo.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento {}", payment);
    }
}
