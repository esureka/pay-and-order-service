package payorder.payservice.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import reactor.kafka.sender.SenderOptions

@Configuration
class KafkaConfig(
    @Value("\${spring.kafka.bootstrap-servers}")
    val bootStrapServer: String = "localhost:9092"
) {

    @Bean
    fun orderProductKafkaTemplate(props: KafkaProperties): ReactiveKafkaProducerTemplate<String, String> =
        ReactiveKafkaProducerTemplate(SenderOptions.create(props.buildProducerProperties()))

}
