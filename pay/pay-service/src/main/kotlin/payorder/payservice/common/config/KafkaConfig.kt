package payorder.payservice.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import payorder.payservice.application.product.event.OrderProductEvent
import payorder.payservice.application.product.event.OrderProductFailedEvent
import reactor.kafka.receiver.ReceiverOptions
import reactor.kafka.sender.SenderOptions

@Configuration
class KafkaConfig(
    @Value("\${spring.kafka.producer.bootstrap-servers}")
    val bootStrapServer: String = "localhost:9092"
) {

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
    fun orderProductKafkaTemplate(props: KafkaProperties): ReactiveKafkaProducerTemplate<String, OrderProductEvent> =
        ReactiveKafkaProducerTemplate(SenderOptions.create(props.buildProducerProperties()))

    @Bean
    fun orderProductFailedKafkaTemplate(props: KafkaProperties): ReactiveKafkaProducerTemplate<String, OrderProductFailedEvent> =
        ReactiveKafkaProducerTemplate(SenderOptions.create(props.buildProducerProperties()))
}
