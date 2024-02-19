package com.valdir.demo.service.impl;

import com.valdir.demo.model.Payment;
import com.valdir.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);
    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebi o pagamento {}", payment);
       // Thread.sleep(1000);

        log.info("Pagamento Enviado");
       kafkaTemplate.send("payment-topic",  payment);


    }

}