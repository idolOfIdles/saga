package com.saga.service

import com.saga.entity.Order
import com.saga.enums.SagaEvents
import com.saga.events.OrderCreateEvent
import com.saga.events.SagaEvent
import com.saga.repository.OrderRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class OrderService(val  orderRepository: OrderRepository, val kafkaTemplate: KafkaTemplate<String, SagaEvent>) {

    fun createOrder(order: Order){
        order.status = SagaEvents.ORDER_CREATED
        val saved = orderRepository.insert(order)
        kafkaTemplate.send("sagaEvent", OrderCreateEvent(saved.orderId!!, order.itemId,order.userId))
    }
    fun updateStatus(orderId: String, status: SagaEvents) {
        val oldOrder = orderRepository.findById(orderId)
        oldOrder.ifPresent {
            it.status = status
            orderRepository.save(it)
        }

    }
}
