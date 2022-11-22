package de.bernard.codec

import de.bernard.model.sensor.SensorType
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext

class SensorTypeCodec: Codec<SensorType> {
    override fun encode(writer: BsonWriter, value: SensorType?, encoderContext: EncoderContext) {
        if (value != null) {
            writer.writeString(value.toString())
        }
    }

    override fun getEncoderClass(): Class<SensorType> {
        return SensorType::class.java
    }

    override fun decode(reader: BsonReader, decoderContext: DecoderContext): SensorType {
        return reader.readString().let { SensorType.valueOf(it) }
    }
}