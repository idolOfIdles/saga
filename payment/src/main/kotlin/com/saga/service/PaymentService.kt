package com.saga.service

import com.saga.model.Payment
import com.saga.model.PaymentSuccessfulEvent
import com.saga.model.SagaEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PaymentService(val kafkaTemplate: KafkaTemplate<String, SagaEvent>) {

    fun makePayment(payment: Payment){
        kafkaTemplate.send("sagaEvent", PaymentSuccessfulEvent.convert(payment))
    }
}
