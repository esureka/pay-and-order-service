package payorder.payservice.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Shop(
    val id: String? = null,
    val name: String,
    val ownerId: Long,
    val starRate: Double
)