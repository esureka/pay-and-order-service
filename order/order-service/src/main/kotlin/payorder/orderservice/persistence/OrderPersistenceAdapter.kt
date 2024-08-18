package payorder.orderservice.persistence

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import payorder.orderservice.application.port.OrderPort
import payorder.orderservice.domain.Order
import reactor.core.publisher.Mono

@Component
class OrderPersistenceAdapter(
    private val orderRepository: OrderRepository
) : OrderPort {

    override suspend fun findById(id: String): Order? =
        orderRepository.findById(id).awaitSingle()

    override suspend fun save(order: Order): Order =
        orderRepository.save(order).awaitSingle()

    override fun saveMono(order: Order): Mono<Order> =
        orderRepository.save(order)

}

