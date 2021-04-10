package com.saga.order.model

import com.saga.order.enums.SagaEvents

data class PaymentFailedEvent(val orderId:String, val userId:String): SagaEvent {
    override fun getEvent(): SagaEvents {
        return SagaEvents.PAYMENT_FAILED
    }
}
