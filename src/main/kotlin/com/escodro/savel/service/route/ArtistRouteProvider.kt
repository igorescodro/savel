package com.escodro.savel.service.route

import io.ktor.server.response.respondText
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

internal class ArtistRouteProvider : RouteProvider {
    override val routes: Routing.() -> Unit = {
        get("/artists/{id}") {
            val id = call.parameters["id"]
            call.respondText("Work in progress - get artist by id: $id")
        }
    }
}
