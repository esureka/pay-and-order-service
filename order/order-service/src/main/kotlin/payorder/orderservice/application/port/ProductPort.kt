package payorder.orderservice.application.port

import payorder.orderservice.domain.Product
import reactor.core.publisher.Mono

interface ProductPort {
    fun findById(id: String): Mono<Product>
}