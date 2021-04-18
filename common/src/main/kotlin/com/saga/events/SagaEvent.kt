package com.saga.events

import com.saga.enums.SagaEvents

interface SagaEvent {
    fun getEvent() : SagaEvents
}
