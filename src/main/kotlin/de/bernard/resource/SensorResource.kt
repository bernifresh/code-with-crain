package de.bernard.resource

import de.bernard.model.sensor.dto.SensorData
import de.bernard.service.SensorService
import io.smallrye.mutiny.Uni
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/sensor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class SensorResource(@Inject private val sensorService: SensorService) {

    @GET
    @Path("/list")
    fun getData(): Uni<Response> {
        return sensorService.getListOfSensors().map { Response.ok(it).build() }
    }
}