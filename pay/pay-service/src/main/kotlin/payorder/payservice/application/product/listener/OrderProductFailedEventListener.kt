package payorder.payservice.application.product.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import payorder.payservice.application.product.ProductService


@Component
class OrderProductFailedEventListener(
    private val productService: ProductService
) {

    private val log = LoggerFactory.getLogger(this::class.simpleName)

    @KafkaListener(topics = ["order-product-failed"], groupId = "payorder")
    fun orderProductFailed(productId: String) {
        log.info("rollback transaction order product = {}",productId)
        productService.rollbackOrder(productId)
    }

}
