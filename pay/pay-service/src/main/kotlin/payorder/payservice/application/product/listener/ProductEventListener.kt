package payorder.payservice.application.product.listener

import org.springframework.context.ApplicationListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import payorder.payservice.application.product.event.OrderProductEvent

@Component
class ProductEventListener(
    private val kafkaTemplate: KafkaTemplate<String, String>
) : ApplicationListener<OrderProductEvent> {

    override fun onApplicationEvent(event: OrderProductEvent) {
        TODO("Not yet implemented")
    }
}