package payorder.payservice.persistence

import org.springframework.stereotype.Component
import payorder.payservice.application.port.ProductPort

@Component
class ProductPersistenceAdapter(
    private val productRepository: ProductRepository
) : ProductPort {
}