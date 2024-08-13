package payorder.payservice.application.shop

import payorder.payservice.domain.Shop
import payorder.payservice.presentation.dto.CreateShopRequest

class ShopCommand {
    class CreateShop(
        val request: CreateShopRequest
    ) {
        fun toEntity(ownerId: Long): Shop {
            return Shop(
                name = request.name,
                ownerId = ownerId,
                starRate = 0.0
            )
        }
    }
}