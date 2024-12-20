package com.escodro.savel.service

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.BadRequestException
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText

fun Application.installStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondText("404: Not found", status = status)
        }

        exception<BadRequestException> { call, status ->
            call.respondText("500: $status", status = HttpStatusCode.BadRequest)
        }
    }
}
