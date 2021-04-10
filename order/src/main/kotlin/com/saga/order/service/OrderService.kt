package com.saga.order.service

import com.saga.order.model.Order
import com.saga.order.model.OrderCreateEvent
import com.saga.order.model.SagaEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class OrderService(val kafkaTemplate: KafkaTemplate<String, SagaEvent>) {

    fun createOrder(order: Order){
        val sagaEvent: SagaEvent = OrderCreateEvent.convertToCreateEvent(order)
        kafkaTemplate.send("sagaEvent", sagaEvent)
    }
}
