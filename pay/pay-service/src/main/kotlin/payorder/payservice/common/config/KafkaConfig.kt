package payorder.payservice.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import payorder.payservice.application.product.event.OrderProductEvent
import reactor.kafka.sender.SenderOptions

@Configuration
class KafkaConfig(
    @Value("\${spring.kafka.producer.bootstrap-servers}")
    val bootStrapServer: String
) {

    @Bean
    fun orderProductKafkaTemplate(props: KafkaProperties): ReactiveKafkaProducerTemplate<String, OrderProductEvent> =
        ReactiveKafkaProducerTemplate(SenderOptions.create(props.buildProducerProperties()))
}
