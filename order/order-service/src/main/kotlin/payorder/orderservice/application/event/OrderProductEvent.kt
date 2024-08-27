package payorder.orderservice.application.event

data class OrderProductEvent(
    val productId: String,
    val userId: Long
)