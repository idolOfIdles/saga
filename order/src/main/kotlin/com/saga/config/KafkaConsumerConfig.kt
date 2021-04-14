package com.saga.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.saga.enums.SagaEvents
import com.saga.model.SagaEvent
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer


@Configuration
class KafkaConsumerConfig {

    @Value("\${kafka.bootstrapAddress}")
    private var brokerAddress = ""


    fun consumerFactory(groupId: String): ConsumerFactory<String?, String?> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = brokerAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = groupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(props)
    }


    fun greetingConsumerFactory(): ConsumerFactory<String, SagaEvent> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = brokerAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = "order"
        return DefaultKafkaConsumerFactory(props, StringDeserializer(), JsonDeserializer(SagaEvent::class.java))
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, SagaEvent> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, SagaEvent> = ConcurrentKafkaListenerContainerFactory<String, SagaEvent>()
        factory.consumerFactory = greetingConsumerFactory()
        factory.setRecordFilterStrategy { r-> listOf(SagaEvents.ORDER_CREATED, SagaEvents.ORDER_CANCELLED).any { it == r.value().getEvent() } }
        return factory
    }


    @KafkaListener(topics = ["sagaEvent"], containerFactory = "kafkaListenerContainerFactory")
    fun greetingListener(greeting: SagaEvent) {
        // process greeting message
        println(greeting)
    }
}

@Configuration
open class JacksonMapper {

    @Bean
    open fun mapper(): ObjectMapper {
        val mapper = ObjectMapper()

        mapper.registerModule(KotlinModule())
        return mapper
    }
}


