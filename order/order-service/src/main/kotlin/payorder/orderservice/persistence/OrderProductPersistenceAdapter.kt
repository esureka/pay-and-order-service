package payorder.orderservice.persistence

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import payorder.orderservice.application.port.OrderProductPort
import payorder.orderservice.domain.OrderProduct
import reactor.core.publisher.Mono

@Component
class OrderProductPersistenceAdapter(
    private val orderProductRepository: OrderProductRepository
) : OrderProductPort {

    override suspend fun save(orderProduct: OrderProduct): OrderProduct =
        orderProductRepository.save(orderProduct).awaitSingle()

    override fun saveMono(orderProduct: OrderProduct): Mono<OrderProduct> =
        orderProductRepository.save(orderProduct)

}