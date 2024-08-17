package payorder.payservice.application

import payorder.payservice.domain.Product
import reactor.core.publisher.Mono

interface ProductPort {
    suspend fun save(product: Product): Product
    suspend fun findById(id: String): Product?
    suspend fun findAll(): List<Product>
    fun findByIdMono(id: String): Mono<Product>
    fun saveMono(product: Product): Mono<Product>
}