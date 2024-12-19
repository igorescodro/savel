package com.escodro.savel.remote.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal class SavelHttpClient {

    val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }

        install(Logging) {
            level = LogLevel.INFO
        }
    }

    val headers: Map<String, String> = mapOf(
        HttpHeaders.UserAgent to "Savel-MusicBrainzService"
    )
}