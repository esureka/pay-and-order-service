package payorder.orderservice.application

import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import payorder.orderservice.application.event.OrderProductFailedEvent
import payorder.orderservice.application.port.OrderPort
import payorder.orderservice.application.port.OrderProductPort
import payorder.orderservice.application.port.ProductPort
import payorder.orderservice.common.error.OrderBasicException
import payorder.orderservice.domain.Order
import payorder.orderservice.domain.OrderProduct
import payorder.orderservice.domain.OrderStatus
import payorder.orderservice.domain.Product
import payorder.orderservice.presentation.dto.OrderDto
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class OrderServiceImpl(
    private val orderPort: OrderPort,
    private val orderProductPort: OrderProductPort,
    private val productPort: ProductPort,
    private val applicationEventPublisher: ApplicationEventPublisher
) : OrderService {

    override suspend fun queryById(id: String): OrderDto {
        val order = orderPort.findById(id)
            ?: throw OrderBasicException("Not Found Order", HttpStatus.NOT_FOUND)

        return OrderDto(
            id = order.id!!,
            totalPrice = order.totalPrice,
            orderDate = order.orderDate,
            status = order.status
        )
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun orderProduct(productId: String, userId: Long) {
        productPort.findById(productId)
            .switchIfEmpty(Mono.error(OrderBasicException("Not Found Product Order..", HttpStatus.NOT_FOUND)))
            .flatMap { createOrder(it, userId) }
            .flatMap { createOrderProduct(it, productId) }
            .retry(3)
            .doOnError { applicationEventPublisher.publishEvent(OrderProductFailedEvent(productId)) }
            .subscribe()

    }

    private fun createOrder(product: Product, userId: Long): Mono<Order> =
        orderPort.saveMono(
            Order(
                totalPrice = product.price,
                orderDate = LocalDateTime.now(),
                status = OrderStatus.WAITING,
                customerId = userId
            )
        )

    private fun createOrderProduct(order: Order, productId: String): Mono<OrderProduct> =
        orderProductPort.saveMono(
            OrderProduct(
                orderId = order.id!!,
                productId = productId
            )
        )

}
