package com.escodro.service

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

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