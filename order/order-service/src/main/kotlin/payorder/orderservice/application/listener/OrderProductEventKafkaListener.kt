package payorder.orderservice.application.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import payorder.orderservice.application.OrderService

@Component
class OrderProductEventKafkaListener(
    private val orderService: OrderService
) {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    @KafkaListener(topics = ["order-product"], groupId = "payorder")
    fun orderProduct(productId: String) {
        log.info("order product event consume = {}", productId)
        orderService.orderProduct(productId)
    }
}
