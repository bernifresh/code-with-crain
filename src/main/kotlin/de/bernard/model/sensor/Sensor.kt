package de.bernard.model.sensor

import java.util.UUID

interface Sensor<T> {
    val type: SensorType
    val value: T
}