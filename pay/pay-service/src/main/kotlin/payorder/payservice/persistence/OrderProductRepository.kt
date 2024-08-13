package payorder.payservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.payservice.domain.OrderProduct

interface OrderProductRepository : ReactiveMongoRepository<OrderProduct, String> {

}