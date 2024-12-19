package com.escodro.savel.data.remote

import com.escodro.savel.core.model.Artist
import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.mapper.ArtistMapper
import com.escodro.savel.data.remote.model.artist.SearchArtistResponse
import com.escodro.savel.data.repository.datasource.MusicBrainzApi
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class MusicBrainzApiImpl(
    private val httpClient: SavelHttpClient,
    private val artistMapper: ArtistMapper,
) : MusicBrainzApi {

    override suspend fun searchArtist(name: String): List<Artist> {
        val response = httpClient.client.get(Url) {
            parameter("query", "artist:\"$name\"")
            parameter("fmt", "json")
            headers {
                httpClient.headers.forEach { (key, value) ->
                    append(key, value)
                }
            }
        }
        val responseBody = response.body<SearchArtistResponse>()
        return artistMapper.toCore(responseBody.artists)
    }

    private companion object {
        const val Url = "https://musicbrainz.org/ws/2/artist/"
    }
}