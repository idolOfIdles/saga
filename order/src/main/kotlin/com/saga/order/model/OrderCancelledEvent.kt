package com.saga.order.model

import com.saga.order.enums.SagaEvents

data class OrderCancelledEvent(val orderId:String, val userId:String) : SagaEvent {
    companion object{
        fun convertToOrderCancelledEvent(order : Order): OrderCancelledEvent{
            return OrderCancelledEvent(order.orderId!!, order.userId)
        }
    }
    override fun getEvent(): SagaEvents {
        return SagaEvents.ORDER_CANCELLED
    }
}
