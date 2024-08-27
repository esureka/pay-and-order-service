package payorder.payservice.common.listener

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.AcknowledgingMessageListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import payorder.payservice.application.product.ProductService
import payorder.payservice.application.product.event.OrderProductFailedEvent


@Component
class OrderProductFailedEventListener(
    private val productService: ProductService,
    private val objectMapper: ObjectMapper
) : AcknowledgingMessageListener<String, String> {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    @KafkaListener(topics = ["order-product-failed"], groupId = "payorder", containerFactory = "orderProductFailedEventListenerContainerFactory")
    override fun onMessage(data: ConsumerRecord<String, String>, acknowledgment: Acknowledgment?) {

        val (key, value) = data.key() to objectMapper.readValue(data.value(), OrderProductFailedEvent::class.java)

        log.info("rollback transaction order product = {}", value.productId)
        productService.rollbackOrder(value.productId)
    }

}
