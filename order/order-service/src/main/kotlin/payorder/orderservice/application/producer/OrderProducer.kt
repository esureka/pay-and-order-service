package payorder.orderservice.application.producer

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component
import payorder.orderservice.application.event.OrderProductFailedEvent

@Component
class OrderProducer(
    private val template: ReactiveKafkaProducerTemplate<String, OrderProductFailedEvent>
) {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    fun sendFailedEvent(event: OrderProductFailedEvent) {
        log.info("failed transaction order product = {}", event.productId)
        template.send("order-product-failed", event)
            .doOnSuccess { result -> log.info("sent {} offset : {}", event, result.recordMetadata().offset()) }
            .subscribe()
    }

}