package payorder.payservice.application.product.event

import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component

@Component
class OrderProductEventProducer(
    private val reactiveKafkaProducerTemplate: ReactiveKafkaProducerTemplate<String, OrderProductEvent>
) {

    fun sendEvent(event: OrderProductEvent) {

    }

}