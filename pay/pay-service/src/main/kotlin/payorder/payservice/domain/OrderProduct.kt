package payorder.payservice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class OrderProduct(
    @Id
    val id: String? = null,
    val orderId: String,
    val productId: String
)