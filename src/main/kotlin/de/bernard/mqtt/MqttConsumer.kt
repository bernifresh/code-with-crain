package de.bernard.mqtt

import de.bernard.model.sensor.dto.SensorData
import de.bernard.model.sensor.entity.SensorEntity
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Message
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MqttConsumer {

    @Incoming("prices")
    fun process(bytes: Message<SensorData>): Uni<Void> {
        return Uni.createFrom().item { bytes }
            .onItem()
            .transform { it.payload }
            .invoke { it -> SensorEntity.create(it) }
            .onFailure()
            .invoke { _ -> println("Failed") }
            .replaceWithVoid()
    }


}