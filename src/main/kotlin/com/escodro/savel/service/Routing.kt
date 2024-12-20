package com.escodro.savel.service

import com.escodro.savel.service.route.RouteProvider
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
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
