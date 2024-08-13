package payorder.payservice.persistence

import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Component
import payorder.payservice.application.ShopPort
import payorder.payservice.domain.Shop

@Component
class ShopPersistenceAdapter(
    private val shopRepository: ShopRepository
) : ShopPort {

    override suspend fun findById(id: String): Shop? =
        shopRepository.findById(id).awaitSingleOrNull()

    override suspend fun findAll(): List<Shop> =
        shopRepository.findAll().collectList().awaitSingle()

    override suspend fun existsByName(name: String): Boolean =
        shopRepository.existsByName(name).awaitSingle()

    override suspend fun save(shop: Shop): Shop =
        shopRepository.save(shop).awaitSingle()
}