package payorder.payservice.application

import payorder.payservice.domain.Product

interface ProductPort {
    suspend fun save(product: Product): Product
    suspend fun findById(id: String): Product?
    suspend fun findAll(): List<Product>
}