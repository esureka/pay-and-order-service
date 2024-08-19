package payorder.orderservice.application.event

data class OrderProductEvent(
    val productId: String,
    val totalPrice: Int,
    val customerId: Long
)
