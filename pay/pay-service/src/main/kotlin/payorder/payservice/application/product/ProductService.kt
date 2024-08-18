package payorder.payservice.application.product

import payorder.payservice.presentation.dto.CreateProductRequest
import payorder.payservice.presentation.dto.ProductResponse
import reactor.core.publisher.Mono

interface ProductService {
    suspend fun createProduct(request: CreateProductRequest)
    suspend fun queryById(id: String): ProductResponse
    suspend fun queryAllProducts(): List<ProductResponse>
    fun orderProduct(id: String, userId: Long): Mono<Void>
}