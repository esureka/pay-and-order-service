package payorder.payservice.common.serializer

import com.fasterxml.jackson.databind.JsonSerializer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer

class CommonJsonSerializer {

    companion object {

        fun getStringObjectMap(bootstrapServer: String): Map<String, Any> {
            val props = HashMap<String, Any>()
            props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer;
            props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
            props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java
            return props
        }
    }
}