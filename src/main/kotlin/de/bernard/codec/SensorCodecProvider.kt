package de.bernard.codec

import de.bernard.model.sensor.SensorType
import org.bson.codecs.Codec
import org.bson.codecs.configuration.CodecProvider
import org.bson.codecs.configuration.CodecRegistry

class SensorCodecProvider: CodecProvider {
    override fun <T : Any?> get(clazz: Class<T>, registry: CodecRegistry): Codec<T>? {
        if (clazz == SensorType::class.java) {
            return  SensorTypeCodec() as Codec<T>
        }
        return null
    }
}