package payorder.orderservice.application.listener

data class OrderProductEvent(
    val productId: String,
    val totalPrice: Int,
    val customerId: Long
)
