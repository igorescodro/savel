package com.escodro.savel.data.remote.musicbrainz.mapper

import com.escodro.savel.core.model.artist.ExternalResource
import com.escodro.savel.core.model.artist.ResourceProvider
import com.escodro.savel.data.remote.musicbrainz.artist.Relation

internal class ExternalResourceMapper {
    fun toExternalResourceList(relationList: List<Relation>): List<ExternalResource> =
        listOfNotNull(
            getSpotifyExternalResource(relationList),
        )

    private fun getSpotifyExternalResource(relationList: List<Relation>): ExternalResource? {
        val url = relationList.find { relation -> relation.url.resource.contains(SPOTIFY_MASK) }?.url?.resource
        val id = url?.split("/")?.get(4) ?: return null

        return ExternalResource(
            provider = ResourceProvider.Spotify,
            id = id,
            url = url,
        )
    }

    private companion object {
        const val SPOTIFY_MASK = "https://open.spotify.com/artist/"
    }
}
