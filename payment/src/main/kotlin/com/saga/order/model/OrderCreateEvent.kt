package com.saga.order.model

import com.saga.order.enums.SagaEvents

data class OrderCreateEvent(val orderId:String, val itemId:String, val userId:String) : SagaEvent {
    companion object{
        fun convertToCreateEvent(order : Order): OrderCreateEvent{
            return OrderCreateEvent(order.orderId!!, order.itemId, order.userId)
        }
    }
    override fun getEvent(): SagaEvents {
        return SagaEvents.ORDER_CREATED
    }
}
