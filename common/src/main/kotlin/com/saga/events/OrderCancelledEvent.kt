package com.saga.events

import com.saga.enums.SagaEvents

data class OrderCancelledEvent(val orderId:String, val userId:String) : SagaEvent {
    override fun getEvent(): SagaEvents {
        return SagaEvents.ORDER_CANCELLED
    }
}
