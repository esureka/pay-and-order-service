package payorder.orderservice.common.config

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate
import org.springframework.kafka.support.converter.StringJsonMessageConverter
import reactor.kafka.sender.SenderOptions


@Configuration
class KafkaConfig {


    @Bean
    fun orderProductFailedKafkaTemplate(props: KafkaProperties): ReactiveKafkaProducerTemplate<String, String> =
        ReactiveKafkaProducerTemplate(SenderOptions.create(props.buildProducerProperties()))

    @Bean
    fun jsonConverter(): StringJsonMessageConverter = StringJsonMessageConverter()

}