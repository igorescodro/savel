package com.escodro.savel.service.route

import io.ktor.server.routing.Routing

internal interface RouteProvider {
    val routes: Routing.() -> Unit
}
