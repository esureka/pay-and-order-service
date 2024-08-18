package payorder.orderservice.persistence

import org.springframework.stereotype.Component
import payorder.orderservice.application.port.ProductPort
import payorder.orderservice.domain.Product
import reactor.core.publisher.Mono

@Component
class ProductPersistenceAdapter(
    private val productRepository: ProductRepository
) : ProductPort {

    override fun findById(id: String): Mono<Product> =
        productRepository.findById(id)
}