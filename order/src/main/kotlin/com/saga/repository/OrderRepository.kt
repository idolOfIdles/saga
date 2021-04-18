package com.saga.repository

import com.saga.entity.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository: MongoRepository<Order,String> {
}
