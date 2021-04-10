package com.saga.order.service

import com.saga.order.model.*
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PaymentService(val kafkaTemplate: KafkaTemplate<String, SagaEvent>) {

    fun makePayment(payment: Payment){
        kafkaTemplate.send("sagaEvent", PaymentSuccessfulEvent.convert(payment))
    }
}
