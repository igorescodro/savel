package com.escodro.savel.data.remote.spotify

import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.spotify.mapper.TokenMapper
import com.escodro.savel.data.remote.spotify.model.SpotifyToken
import com.escodro.savel.data.repository.datasource.RetrieveTokenDataSource
import com.escodro.savel.data.repository.model.Token
import io.ktor.client.call.body
import io.ktor.client.request.forms.submitForm
import io.ktor.http.Parameters
import io.ktor.http.headers
import io.ktor.server.config.HoconApplicationConfig

internal class SpotifyApi(
    private val httpClient: SavelHttpClient,
    private val config: HoconApplicationConfig,
    private val mapper: TokenMapper,
) : RetrieveTokenDataSource {
    override suspend fun refreshToken(): Token? {
        val clientId = config.property("api.spotify.clientId").getString()
        val clientSecret = config.property("api.spotify.clientSecret").getString()

        val response =
            httpClient.client.submitForm(
                url = "${URL}api/token",
                formParameters =
                    Parameters.build {
                        append("grant_type", "client_credentials")
                        append("client_id", clientId)
                        append("client_secret", clientSecret)
                    },
            ) {
                headers {
                    httpClient.headers.forEach { (key, value) ->
                        append(key, value)
                    }
                }
            }

        val token = response.body<SpotifyToken>()
        return mapper.toRepo(token)
    }

    private companion object {
        const val URL = "https://accounts.spotify.com/"
    }
}
