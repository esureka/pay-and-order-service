package payorder.payservice.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Product(
    val id: String? = null,
    val name: String,
    val price: Int,
    val category: ProductCategory,
    val shopId: String
)

enum class ProductCategory(val description: String) {
    FOOD("음식"),
    CLOTHING("의류"),
    ELECTRONICS("전자제품"),
    FURNITURE("가구")
}