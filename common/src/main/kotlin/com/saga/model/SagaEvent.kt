package com.saga.model

import com.saga.enums.SagaEvents

interface SagaEvent {
    fun getEvent() : SagaEvents
}
