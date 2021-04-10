package com.saga.order.model

data class Payment(val orderId:String, val transactionId:String, val userId:String)
