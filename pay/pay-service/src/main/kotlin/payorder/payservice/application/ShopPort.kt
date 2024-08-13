package payorder.payservice.application

import payorder.payservice.domain.Shop

interface ShopPort {
    suspend fun findById(id: String): Shop?
    suspend fun findAll(): List<Shop>
    suspend fun existsByName(name: String): Boolean
    suspend fun save(shop: Shop): Shop
}