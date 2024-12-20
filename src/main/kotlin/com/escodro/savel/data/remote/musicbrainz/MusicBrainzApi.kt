package com.escodro.savel.data.remote.musicbrainz

import com.escodro.savel.core.model.artist.Artist
import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.musicbrainz.artist.SearchArtistResponse
import com.escodro.savel.data.remote.musicbrainz.mapper.ArtistMapper
import com.escodro.savel.data.repository.datasource.ArtistDataSource
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import com.escodro.savel.core.model.artist.Artist as CoreArtist
import com.escodro.savel.data.remote.musicbrainz.artist.Artist as RepoArtist

internal class MusicBrainzApi(
    private val httpClient: SavelHttpClient,
    private val artistMapper: ArtistMapper,
) : ArtistDataSource {
    override suspend fun searchArtist(name: String): List<CoreArtist> {
        val response =
            httpClient.client.get(URL) {
                parameter("query", "artist:\"$name\"")
                parameter("fmt", "json")
                parameter("limit", "10")
                headers {
                    httpClient.headers.forEach { (key, value) ->
                        append(key, value)
                    }
                }
            }
        val responseBody = response.body<SearchArtistResponse>()
        val artistList = responseBody.artists
        return getArtistWithResourceIds(artistList = artistList)
    }

    private suspend fun getArtistWithResourceIds(artistList: List<RepoArtist>): List<Artist> =
        coroutineScope {
            val deferredResponses =
                artistList.map { artist ->
                    async {
                        val response =
                            httpClient.client.get("$URL${artist.id}") {
                                parameter("fmt", "json")
                                parameter("inc", "url-rels")
                                headers {
                                    httpClient.headers.forEach { (key, value) ->
                                        append(key, value)
                                    }
                                }
                            }
                        val responseBody = response.body<RepoArtist>()
                        artistMapper.toCore(
                            artist = artist,
                            relationList = responseBody.relations,
                        )
                    }
                }
            deferredResponses.awaitAll()
        }

    private companion object {
        const val URL = "https://musicbrainz.org/ws/2/artist/"
    }
}
