package payorder.orderservice.application.producer

import org.slf4j.LoggerFactory
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.stereotype.Component

@Component
class OrderProducer(
    private val template: ReactiveKafkaProducerTemplate<String, String>
) {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    fun sendFailedEvent(productId: String) {
        log.info("failed transaction order product = {}", productId)
        template.send("order-product-failed", productId)
            .doOnSuccess { result -> log.info("sent {} offset : {}", productId, result.recordMetadata().offset()) }
            .subscribe()
    }

}
