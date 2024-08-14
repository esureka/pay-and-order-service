package payorder.payservice.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import payorder.payservice.application.product.ProductService
import payorder.payservice.presentation.dto.CreateProductRequest
import payorder.payservice.presentation.dto.ProductResponse

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    suspend fun createProduct(@RequestBody request: CreateProductRequest) {
        productService.createProduct(request)
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    suspend fun queryById(@PathVariable id: String): ProductResponse {
        return productService.queryById(id)
    }

}