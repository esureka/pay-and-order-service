package payorder.payservice.persistence

import org.springframework.stereotype.Component
import payorder.payservice.application.port.ShopPort

@Component
class ShopPersistenceAdapter(
    private val shopRepository: ShopRepository
) : ShopPort {
}