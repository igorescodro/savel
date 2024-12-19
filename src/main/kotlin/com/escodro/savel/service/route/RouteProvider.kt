package com.escodro.savel.service.route

import io.ktor.server.routing.*

internal interface RouteProvider {

    val routes: Routing.() -> Unit
}