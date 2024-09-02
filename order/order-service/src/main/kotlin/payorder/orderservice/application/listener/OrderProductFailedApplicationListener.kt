package payorder.orderservice.application.listener

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener
import payorder.orderservice.application.event.OrderProductFailedEvent
import payorder.orderservice.common.publisher.TransactionEventPublisher
import payorder.orderservice.common.util.TokenGenerator
import reactor.core.publisher.Mono
import reactor.kafka.sender.SenderResult

@Component
class OrderProductFailedApplicationListener(
    private val eventPublisher: TransactionEventPublisher
) {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    fun onEvent(event: OrderProductFailedEvent): Mono<SenderResult<Void>> {
        val sagaKey = TokenGenerator.randomCharacter(16)
        return eventPublisher.publishEvent("order-product-failed", sagaKey, event)
    }

}
