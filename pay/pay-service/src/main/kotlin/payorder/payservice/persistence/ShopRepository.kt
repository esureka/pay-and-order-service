package payorder.payservice.persistence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import payorder.payservice.domain.Shop
import reactor.core.publisher.Mono

interface ShopRepository : ReactiveMongoRepository<Shop, String> {
    fun existsByName(name: String): Mono<Boolean>
}