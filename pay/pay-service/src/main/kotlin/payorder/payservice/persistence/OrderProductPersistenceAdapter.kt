package payorder.payservice.persistence

import org.springframework.stereotype.Component
import payorder.payservice.application.port.OrderProductPort

@Component
class OrderProductPersistenceAdapter(
    private val orderProductRepository: OrderProductRepository
) : OrderProductPort{
}