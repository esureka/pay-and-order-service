package payorder.payservice.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import payorder.payservice.application.product.event.OrderProductEvent
import payorder.payservice.common.serializer.CommonJsonSerializer

@Configuration
class KafkaConfig(
    @Value("\${spring.kafka.producer.bootstrap-servers}")
    val bootStrapServer: String
) {

    @Bean
    fun orderProducerConfig(): Map<String, Any> {
        return CommonJsonSerializer.getStringObjectMap(bootStrapServer)
    }

    @Bean
    fun orderProductDTOProducerFactory(): ProducerFactory<String, OrderProductEvent> =
        DefaultKafkaProducerFactory(orderProducerConfig())

    @Bean
    fun orderProductKafkaTemplate(): KafkaTemplate<String, OrderProductEvent> =
        KafkaTemplate(orderProductDTOProducerFactory())
}
