package payorder.payservice.application.product.producer

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component

@Component
class OrderProductEventProducer(
    private val template: ReactiveKafkaProducerTemplate<String, String>
) {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    fun sendEvent(productId: String) {
        log.info("order product event produce = {}", productId)
        template.send("order-product", productId)
            .doOnSuccess { result -> log.info("sent {} offset : {}", productId, result.recordMetadata().offset()) }
            .subscribe()
    }

}