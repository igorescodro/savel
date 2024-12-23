package com.escodro.savel.data.remote.musicbrainz

import com.escodro.savel.core.model.artist.SearchArtist
import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.musicbrainz.mapper.ArtistMapper
import com.escodro.savel.data.remote.musicbrainz.model.artist.SearchArtistResponse
import com.escodro.savel.data.repository.datasource.ArtistDataSource
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import com.escodro.savel.data.remote.musicbrainz.model.artist.Artist as RepoArtist

internal class MusicBrainzArtistDataSource(
    private val httpClient: SavelHttpClient,
    private val artistMapper: ArtistMapper,
) : ArtistDataSource {
    override suspend fun searchArtist(name: String): List<SearchArtist> {
        val response =
            httpClient.client.get(URL) {
                parameter("query", "artist:\"$name\"")
                parameter("fmt", "json")
                parameter("limit", "10")
            }
        val responseBody = response.body<SearchArtistResponse>()
        val artistList = responseBody.artists
        return getArtistWithResourceIds(artistList = artistList)
    }

    private suspend fun getArtistWithResourceIds(artistList: List<RepoArtist>): List<SearchArtist> =
        coroutineScope {
            val deferredResponses =
                artistList.map { artist ->
                    async {
                        val response =
                            httpClient.client.get("$URL/${artist.id}") {
                                parameter("fmt", "json")
                                parameter("inc", "url-rels")
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
        const val URL = "https://musicbrainz.org/ws/2/artist"
    }
}
