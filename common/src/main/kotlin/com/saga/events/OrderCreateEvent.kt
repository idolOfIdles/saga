package com.saga.events

import com.saga.enums.SagaEvents

data class OrderCreateEvent(val orderId:String, val itemId:String, val userId:String) : SagaEvent {
    override fun getEvent(): SagaEvents {
        return SagaEvents.ORDER_CREATED
    }
}
