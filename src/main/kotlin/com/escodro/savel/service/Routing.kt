package com.escodro.savel.service

import com.escodro.savel.service.route.RouteProvider
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.getKoin

fun Application.configureRouting() {

    installStatusPages()

    install(ContentNegotiation) {
        json()
    }

    val routes: List<RouteProvider> = getKoin().getAll()

    routing {
        routes.forEach { provider -> provider.routes(this) }
    }
}