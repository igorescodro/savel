package com.escodro.service

import com.escodro.domain.model.SearchArtistResponse
import com.escodro.domain.usecase.SearchArtist
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    installStatusPages()

    install(ContentNegotiation) {
        json()
    }

    val searchArtist: SearchArtist by inject()

    routing {
        get("/search/{query}") {
            val searchResult: Result<SearchArtistResponse> = searchArtist(name = call.parameters["query"])
            call.respond(searchResult.getOrThrow())
        }
    }
}