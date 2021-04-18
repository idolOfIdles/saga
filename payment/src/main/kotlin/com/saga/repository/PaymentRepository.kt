package com.saga.repository

import com.saga.entity.Payment
import org.springframework.data.mongodb.repository.MongoRepository

interface PaymentRepository: MongoRepository<Payment, String> {
}
