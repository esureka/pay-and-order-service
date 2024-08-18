package payorder.orderservice.application.port

import payorder.orderservice.domain.Order
import reactor.core.publisher.Mono

interface OrderPort {
    suspend fun findById(id: String): Order?
    suspend fun save(order: Order): Order
    fun saveMono(order: Order): Mono<Order>
}