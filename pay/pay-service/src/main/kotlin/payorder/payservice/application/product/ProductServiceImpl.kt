package payorder.payservice.application.product

import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import payorder.payservice.application.ProductPort
import payorder.payservice.application.product.event.OrderProductEvent
import payorder.payservice.common.error.PayBasicException
import payorder.payservice.domain.Product
import payorder.payservice.presentation.dto.CreateProductRequest
import payorder.payservice.presentation.dto.ProductResponse

@Service
class ProductServiceImpl(
    private val productPort: ProductPort,
    private val publisher: ApplicationEventPublisher
) : ProductService {

    override suspend fun createProduct(request: CreateProductRequest) {
        productPort.save(
            Product(
                name = request.name,
                price = request.price,
                category = request.productCategory,
                amount = request.amount,
                shopId = request.shopId
            )
        )
    }

    override suspend fun queryById(id: String): ProductResponse {
        val product = productPort.findById(id) ?: throw PayBasicException("Not Found Product", HttpStatus.NOT_FOUND)
        return ProductResponse(
            product.id!!,
            product.name,
            product.price,
            product.category,
            product.amount,
            product.shopId
        )
    }

    override suspend fun queryAllProducts(): List<ProductResponse> =
        productPort.findAll().map {
            ProductResponse(
                id = it.id!!,
                name = it.name,
                price = it.price,
                productCategory = it.category,
                amount = it.amount,
                shopId = it.shopId
            )
        }

    override suspend fun orderProduct(id: String, userId: String) {
        val product = productPort.findById(id)
            ?: throw PayBasicException("Not Found Product", HttpStatus.NOT_FOUND)

        product.minusAmount()
        publisher.publishEvent(OrderProductEvent(productId = id, totalPrice = product.price, this))
    }
}