package payorder.payservice.persistence

import org.springframework.stereotype.Component
import payorder.payservice.application.OrderProductPort

@Component
class OrderProductPersistenceAdapter(
    private val orderProductRepository: OrderProductRepository
) : OrderProductPort {
}