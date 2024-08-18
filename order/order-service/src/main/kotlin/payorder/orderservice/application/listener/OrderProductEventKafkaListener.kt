package payorder.orderservice.application.listener

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import payorder.orderservice.application.OrderService

@Component
class OrderProductEventKafkaListener(
    private val orderService: OrderService
) {

    @KafkaListener(topics = ["order-product"], groupId = "payorder")
    fun orderProduct(orderProductEvent: OrderProductEvent) {
        orderService.orderProduct(orderProductEvent.productId, orderProductEvent.customerId)
    }
}
