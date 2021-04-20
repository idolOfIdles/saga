package com.saga.events

import com.saga.enums.SagaEvents

data class OrderCompletedEvent(val orderId:String) : SagaEvent {
    override fun getEvent(): SagaEvents {
        return SagaEvents.ORDER_COMPLETED
    }
}
