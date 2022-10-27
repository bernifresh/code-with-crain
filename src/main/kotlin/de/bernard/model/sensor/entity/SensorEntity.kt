package de.bernard.model.sensor.entity

import de.bernard.annotation.DTO
import de.bernard.model.sensor.DeviceType
import de.bernard.model.sensor.Sensor
import de.bernard.model.sensor.SensorType
import de.bernard.model.sensor.dto.SensorData
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntityBase
import org.bson.BsonType
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonDiscriminator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.codecs.pojo.annotations.BsonRepresentation
import org.bson.types.ObjectId
import java.util.*

@DTO
data class SensorEntity @BsonCreator constructor(
    @BsonId val id: ObjectId,
    @BsonProperty("type")
    override val type: String,
    @BsonProperty("deviceType")
    override val deviceType: String,
    @BsonProperty("deviceId")
    override val deviceId: String,
    @BsonProperty("value")
    override val value: Int
) : PanacheMongoEntityBase(), Sensor<Int> {
    companion object : PanacheMongoCompanion<SensorEntity> {
        fun findAllData(): List<SensorEntity> = findAll().list()

        fun create(sensorData: SensorData): Unit = persist(SensorEntity(ObjectId.get(), "", "", "", sensorData.value))
    }
}
