package payorder.orderservice.common.listener

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.AcknowledgingMessageListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component
import payorder.orderservice.application.OrderService
import payorder.orderservice.application.event.OrderProductEvent

@Component
class OrderProductEventKafkaListener(
    private val orderService: OrderService,
    private val objectMapper: ObjectMapper
) : AcknowledgingMessageListener<String, String> {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    @KafkaListener(topics = ["order-product"], groupId = "payorder", containerFactory = "orderProductEventListenerContainerFactory")
    override fun onMessage(data: ConsumerRecord<String, String>, acknowledgment: Acknowledgment?) {
        val (key, value) = data.key() to objectMapper.readValue(data.value(), OrderProductEvent::class.java)
        log.info("rollback transaction order product = {}", value.productId)
        orderService.orderProduct(value.productId, value.userId)
    }
}
