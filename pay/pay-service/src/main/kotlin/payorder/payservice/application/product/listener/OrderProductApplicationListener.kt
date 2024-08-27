package payorder.payservice.application.product.listener

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener
import payorder.payservice.application.product.event.OrderProductEvent
import payorder.payservice.common.publisher.KafkaTransactionEventPublisher
import payorder.payservice.common.util.TokenGenerator
import reactor.core.publisher.Mono
import reactor.kafka.sender.SenderResult

@Component
class OrderProductApplicationListener(
    private val kafkaTransactionEventPublisher: KafkaTransactionEventPublisher
) {

    @Async(value = "orderProductEventApplicationListener")
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    fun onEvent(event: OrderProductEvent): Mono<SenderResult<Void>> {
        val sagaKey = TokenGenerator.randomCharacter(16)
        return kafkaTransactionEventPublisher.publishEvent("order-product", sagaKey, event)
    }
}