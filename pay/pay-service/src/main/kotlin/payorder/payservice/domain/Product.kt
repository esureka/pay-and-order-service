package payorder.payservice.domain

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.http.HttpStatus
import payorder.payservice.common.error.PayBasicException

@Document
class Product(
    val id: String? = null,
    val name: String,
    val price: Int,
    val category: ProductCategory,
    var amount: Int,
    val shopId: String
) {
    fun minusAmount() : Product {
        if(this.amount == 0) throw PayBasicException("Amount is 0", HttpStatus.FORBIDDEN)
        this.amount--
        return this
    }

    fun plusAmount(): Product {
        this.amount++
        return this
    }
}

enum class ProductCategory(val description: String) {
    FOOD("음식"),
    CLOTHING("의류"),
    ELECTRONICS("전자제품"),
    FURNITURE("가구")
}