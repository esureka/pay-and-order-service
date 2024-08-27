package payorder.payservice.application.product.event

data class OrderProductEvent(
    val productId: String,
    val userId: Long
)
