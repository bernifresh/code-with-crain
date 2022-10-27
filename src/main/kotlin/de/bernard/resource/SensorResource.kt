package de.bernard.resource

import de.bernard.service.SensorService
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/sensor")
class SensorResource(@Inject private var sensorService: SensorService) {

    @GET
    @Path("/list")
    fun getData(): Uni<Response> {
        return sensorService.getListOfSensors().map { Response.ok(it).build() }
    }

}