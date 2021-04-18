package com.saga.entity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id

@Document
data class Order(val itemId:String, val userId:String, @Id val orderId:String?)
