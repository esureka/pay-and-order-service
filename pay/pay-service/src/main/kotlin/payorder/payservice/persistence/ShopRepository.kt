package payorder.payservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.payservice.domain.Shop

interface ShopRepository : ReactiveMongoRepository<Shop, String> {
}