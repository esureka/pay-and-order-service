package payorder.payservice.application.product

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import payorder.payservice.application.ProductPort
import payorder.payservice.common.error.PayBasicException
import payorder.payservice.domain.Product
import payorder.payservice.presentation.dto.CreateProductRequest
import payorder.payservice.presentation.dto.ProductResponse

@Service
class ProductServiceImpl(
    private val productPort: ProductPort
) : ProductService {

    override suspend fun createProduct(request: CreateProductRequest) {
        productPort.save(
            Product(
                name = request.name,
                price = request.price,
                category = request.productCategory,
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
                shopId = it.shopId
            )
        }
}