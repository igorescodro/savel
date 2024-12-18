package com.escodro.service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation as ClientContentNegotiation
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation as ServerContentNegotiation

fun Application.configureRouting() {

    install(ServerContentNegotiation) {
        json()
    }

    val client = HttpClient(CIO) {
        install(ClientContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }

        install(Logging) {
            level = LogLevel.INFO
        }
    }

    routing {
        get("/search/{query}") {
            val query = call.parameters["query"] ?: return@get call.respond(HttpStatusCode.BadRequest)
            val searchResult = searchArtist(client, query)
            try {
                call.respond(searchResult)
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError)
            }
        }
    }
}

private suspend fun searchArtist(client: HttpClient, artistName: String): Response {
    val url = "https://musicbrainz.org/ws/2/artist/"
    val response = client.get(url) {
        parameter("query", "artist:\"$artistName\"")
        parameter("fmt", "json")
        headers {
            append(HttpHeaders.UserAgent, "Savel-MusicBrainzService")
        }
    }
    return response.body<Response>()
}

@Serializable
private data class Response(
    @SerialName("artists") val artists: List<Artist>
)

@Serializable
private data class Artist(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("country") val country: String? = null,
)
