package payorder.orderservice.common.deserializer

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import org.springframework.kafka.support.serializer.JsonDeserializer

class CommonJsonDeserializer {

    companion object {

        fun getStringObjectMap(bootstrapServer: String): Map<String, Any> {
            val props = HashMap<String, Any>()
            props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer;
            props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = ErrorHandlingDeserializer::class.java
            props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = ErrorHandlingDeserializer::class.java
            props[ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS] = StringDeserializer::class.java
            props[ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS] = JsonDeserializer::class.java
            props[JsonDeserializer.TRUSTED_PACKAGES] = "*"
            return props
        }
    }

}
