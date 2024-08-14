package payorder.payservice.presentation.dto

import payorder.payservice.domain.ProductCategory

data class CreateProductRequest(
    val name: String,
    val price: Int,
    val productCategory: ProductCategory,
    val shopId: String
)
