package payorder.payservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.payservice.domain.Product

interface ProductRepository : ReactiveMongoRepository<Product, String> {
}