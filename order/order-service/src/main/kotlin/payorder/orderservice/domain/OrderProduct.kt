package payorder.orderservice.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document
class OrderProduct(
    val id: String? = null,
    val orderId: String,
    val productId: String
)