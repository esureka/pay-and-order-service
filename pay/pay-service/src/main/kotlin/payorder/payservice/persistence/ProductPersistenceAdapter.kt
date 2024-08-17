package payorder.payservice.persistence

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import payorder.payservice.application.ProductPort
import payorder.payservice.domain.Product
import reactor.core.publisher.Mono

@Component
class ProductPersistenceAdapter(
    private val productRepository: ProductRepository
) : ProductPort {

    override suspend fun save(product: Product): Product =
        productRepository.save(product).awaitSingle()
    override suspend fun findById(id: String): Product? =
        productRepository.findById(id).awaitSingle()
    override suspend fun findAll(): List<Product> =
        productRepository.findAll().collectList().awaitSingle()

    override fun findByIdMono(id: String): Mono<Product> =
        productRepository.findById(id)

    override fun saveMono(product: Product): Mono<Product> =
        productRepository.save(product)

}

