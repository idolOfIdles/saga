package com.saga.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaTopicConfig {

    @Value("\${kafka.bootstrapAddress}")
    private var brokerAddress = ""


    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs = mutableMapOf<String,Any>()
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, brokerAddress)
        return KafkaAdmin(configs)
    }



}


