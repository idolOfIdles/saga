package com.saga.order.model

import com.saga.order.enums.SagaEvents

interface SagaEvent {
    fun getEvent() : SagaEvents
}
