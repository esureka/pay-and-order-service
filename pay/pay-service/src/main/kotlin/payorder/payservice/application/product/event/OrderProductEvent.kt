package payorder.payservice.application.product.event

import org.springframework.context.ApplicationEvent

data class OrderProductEvent(
    val productId: String,
    val totalPrice: Int,
    val source: Any
) : ApplicationEvent(source)
