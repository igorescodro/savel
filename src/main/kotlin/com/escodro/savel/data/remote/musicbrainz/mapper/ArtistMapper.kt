package com.escodro.savel.data.remote.musicbrainz.mapper

import com.escodro.savel.data.remote.musicbrainz.artist.Artist
import com.escodro.savel.data.remote.musicbrainz.artist.Relation
import com.escodro.savel.core.model.artist.Artist as CoreArtist

internal class ArtistMapper(
    private val externalResourceMapper: ExternalResourceMapper,
) {

    fun toCore(artist: Artist, relationList: List<Relation>?): CoreArtist =
        CoreArtist(
            id = artist.id,
            name = artist.name,
            externalResourceList = relationList
                ?.let { externalResourceMapper.toExternalResourceList(it) }
                ?: emptyList(),
        )
}