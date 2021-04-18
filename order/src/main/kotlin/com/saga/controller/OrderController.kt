package com.saga.controller

import com.saga.entity.Order
import com.saga.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderController(val orderService: OrderService) {


    @PostMapping("/api/order")
    fun createOrder(@RequestBody order: Order){
        orderService.createOrder(order)
    }
}
