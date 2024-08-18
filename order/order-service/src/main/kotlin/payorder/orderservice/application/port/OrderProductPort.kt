package payorder.orderservice.application.port

import payorder.orderservice.domain.OrderProduct
import reactor.core.publisher.Mono

interface OrderProductPort {
    suspend fun save(orderProduct: OrderProduct): OrderProduct
    fun saveMono(orderProduct: OrderProduct): Mono<OrderProduct>
}