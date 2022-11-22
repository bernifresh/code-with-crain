package de.bernard.service

import de.bernard.model.sensor.SensorType
import de.bernard.model.sensor.dto.SensorData
import de.bernard.model.sensor.entity.SensorEntity
import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SensorService {

    fun getListOfSensors(): Uni<List<Int>> {
        return Uni.createFrom().item { SensorEntity.findAllData().map { it.value } }
    }
}