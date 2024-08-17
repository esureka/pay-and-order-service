package payorder.payservice.application.product.event

data class OrderProductEvent(
    val productId: String,
    val totalPrice: Int,
    val customerId: Long,
    val source: Any
)
