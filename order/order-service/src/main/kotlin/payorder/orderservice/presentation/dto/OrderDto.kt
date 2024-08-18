package payorder.orderservice.presentation.dto

import payorder.orderservice.domain.OrderStatus
import java.time.LocalDateTime

data class OrderDto(
    val id: String,
    val totalPrice: Int,
    val orderDate: LocalDateTime,
    val status: OrderStatus
)
