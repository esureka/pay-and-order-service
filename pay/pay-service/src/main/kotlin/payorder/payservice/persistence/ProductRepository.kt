package payorder.payservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.payservice.domain.Product
import reactor.core.publisher.Mono

interface ProductRepository : ReactiveMongoRepository<Product, String> {
}