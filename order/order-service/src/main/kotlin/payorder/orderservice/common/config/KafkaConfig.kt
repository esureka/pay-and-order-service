package payorder.orderservice.common.config

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.support.converter.StringJsonMessageConverter
import payorder.orderservice.application.listener.OrderProductEvent
import reactor.kafka.receiver.ReceiverOptions

@Configuration
class KafkaConfig {

    @Bean
    fun reactiveKafkaConsumerTemplate(props: KafkaProperties): ReactiveKafkaConsumerTemplate<String, OrderProductEvent> {
        val consumerProperties = props.buildConsumerProperties().toMutableMap().apply {
            putAll(
                mapOf(
                    // value 값을 deserialize 할때 타입을 참조할 dto 을 정의
                    "spring.json.value.default.type" to OrderProductEvent::class.java
                )
            )
        }
        return ReactiveKafkaConsumerTemplate(ReceiverOptions.create(consumerProperties))
    }

    @Bean
    fun jsonConverter(): StringJsonMessageConverter = StringJsonMessageConverter()

}