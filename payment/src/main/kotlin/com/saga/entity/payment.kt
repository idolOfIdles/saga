package com.saga.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Payment(@Id val transactionId: String?, val orderID: String, val userId: String) {
}
