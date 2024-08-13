package payorder.payservice.application.shop

import payorder.payservice.presentation.dto.CreateShopRequest
import payorder.payservice.presentation.dto.ShopResponse

interface ShopService {
    suspend fun createShop(request: CreateShopRequest)
    suspend fun queryAllShop(): List<ShopResponse>
    suspend fun queryById(id: String): ShopResponse
}