package payorder.orderservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.orderservice.domain.OrderProduct

interface OrderProductRepository : ReactiveMongoRepository<OrderProduct, String> {
}