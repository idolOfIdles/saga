package com.saga.order.controller

import com.saga.order.model.Order
import com.saga.order.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderController(val orderService: OrderService) {


    @PostMapping("/api/order")
    fun createOrder(@RequestBody order:Order){
        orderService.createOrder(order)
    }
}
