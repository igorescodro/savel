package com.escodro.savel.data.remote.spotify

import com.escodro.savel.core.model.artist.ArtistImage
import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.spotify.model.artist.ArtistResponse
import com.escodro.savel.data.repository.datasource.ArtistImageDataSource
import com.escodro.savel.data.repository.datasource.StoreTokenDataSource
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get

internal class SpotifyArtistDataSource(
    private val httpClient: SavelHttpClient,
    private val tokenDataSource: StoreTokenDataSource,
) : ArtistImageDataSource {
    override suspend fun getArtistImage(artistId: String): ArtistImage {
        val token = tokenDataSource.getToken() ?: return ArtistImage(imageUrl = null)
        val response =
            httpClient.client.get("$URL/artists/$artistId/") {
                bearerAuth(token.value)
            }

        val artistImage = response.body<ArtistResponse>()
        return ArtistImage(
            artistImage.images
                .firstOrNull()
                ?.url
                .orEmpty(),
        )
    }

    private companion object {
        private const val URL = "https://api.spotify.com/v1"
    }
}
