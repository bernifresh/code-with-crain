package de.bernard.mqtt

import de.bernard.model.sensor.dto.SensorData
import io.smallrye.reactive.messaging.MessageConverter
import io.vertx.core.json.Json
import org.eclipse.microprofile.reactive.messaging.Message
import java.lang.reflect.Type
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SensorDataConverter: MessageConverter {
    override fun canConvert(`in`: Message<*>, target: Type): Boolean {
        return `in`.payload.javaClass == ByteArray::class.java && target == SensorData::class.java
    }

    override fun convert(`in`: Message<*>, target: Type): Message<*> {
        val payload = Json.decodeValue(String(`in`.payload as ByteArray), SensorData::class.java)
        return `in`.withPayload(payload)
    }
}