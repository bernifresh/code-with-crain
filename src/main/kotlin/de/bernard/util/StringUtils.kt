package de.bernard.util

import io.vertx.core.json.JsonObject

fun String.json(): JsonObject = this.let {
    JsonObject.mapFrom(io.vertx.core.json.Json.decodeValue(it))
}
