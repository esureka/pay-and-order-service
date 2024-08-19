package payorder.payservice.application.product.producer

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component
import payorder.payservice.application.product.event.OrderProductEvent

@Component
class OrderProductEventProducer(
    private val template: ReactiveKafkaProducerTemplate<String, OrderProductEvent>
) {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    fun sendEvent(event: OrderProductEvent) {
        log.info("order product event produce = {}", event)
        template.send("order-product", event)
            .doOnSuccess { result -> log.info("sent {} offset : {}", event, result.recordMetadata().offset()) }
            .subscribe()
    }

}