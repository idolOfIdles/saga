package com.saga.events

import com.saga.enums.SagaEvents

data class PaymentSuccessfulEvent(val orderId:String, val transactionId:String, val userId:String): SagaEvent {
    override fun getEvent(): SagaEvents {
        return SagaEvents.PAYMENT_SUCCESSFUL
    }
}
