package com.saga.service

import com.saga.entity.Payment
import com.saga.events.PaymentSuccessfulEvent
import com.saga.events.SagaEvent
import com.saga.repository.PaymentRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PaymentService(val kafkaTemplate: KafkaTemplate<String, SagaEvent>, val paymentRepository: PaymentRepository) {

    fun makePayment(payment: Payment){
        val saved = paymentRepository.insert(payment)
        kafkaTemplate.send("sagaEvent", PaymentSuccessfulEvent(payment.orderID, saved.transactionId!!, payment.userId))
    }
}
