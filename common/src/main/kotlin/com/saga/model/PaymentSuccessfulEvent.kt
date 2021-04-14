package com.saga.model

import com.saga.enums.SagaEvents

data class PaymentSuccessfulEvent(val orderId:String, val transactionId:String, val userId:String): SagaEvent {
    companion object{
        fun convert(payment: Payment): PaymentSuccessfulEvent{
            return PaymentSuccessfulEvent(payment.orderId, payment.transactionId, "")
        }

    }
    override fun getEvent(): SagaEvents {
        return SagaEvents.PAYMENT_SUCCESSFUL
    }
}
