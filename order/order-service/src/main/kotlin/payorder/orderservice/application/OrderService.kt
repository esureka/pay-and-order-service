package payorder.orderservice.application

import payorder.orderservice.presentation.dto.OrderDto

interface OrderService {
    suspend fun queryById(id: String): OrderDto
    fun orderProduct(productId: String)
}