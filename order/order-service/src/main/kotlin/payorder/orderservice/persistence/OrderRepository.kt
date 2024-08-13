package payorder.orderservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.orderservice.domain.Order

interface OrderRepository : ReactiveMongoRepository<Order, String> {
}