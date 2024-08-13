package payorder.orderservice.persistence

import org.springframework.stereotype.Component
import payorder.orderservice.application.port.OrderPort

@Component
class OrderPersistenceAdapter(
    private val orderRepository: OrderRepository
) : OrderPort {
}