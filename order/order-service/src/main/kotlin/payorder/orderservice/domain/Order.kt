package payorder.orderservice.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Order(
    @Id
    val id: String? = null,
    val totalPrice: Int,
    val orderDate: LocalDateTime,
    val status: OrderStatus,
    val customerId: Long
)

enum class OrderStatus(val description: String) {
    WAITING("주문 대기중"),
    COMPLETE("주문 완료"),
    CANCELED("주문 취소"),
    DELIVERY_PREPARE("배송 준비"),
    IN_DELIVERY("배송중"),
    DELIVERY_COMPLETE("배송 완료")
}