package de.bernard.model.sensor

import java.util.UUID

interface Sensor<T> {
    val type: String
    val deviceType: String
    val deviceId: String
    val value: T
}