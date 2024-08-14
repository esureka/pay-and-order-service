package payorder.payservice.presentation.dto

import payorder.payservice.domain.ProductCategory

data class ProductResponse(
    val id: String,
    val name: String,
    val price: Int,
    val productCategory: ProductCategory,
    val shopId: String
)
