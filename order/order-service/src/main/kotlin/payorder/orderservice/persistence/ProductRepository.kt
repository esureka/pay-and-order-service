package payorder.orderservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.orderservice.domain.Product

interface ProductRepository : ReactiveMongoRepository<Product, String>{
}