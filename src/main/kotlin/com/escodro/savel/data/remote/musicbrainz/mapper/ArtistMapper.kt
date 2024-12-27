package com.escodro.savel.data.remote.musicbrainz.mapper

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.core.model.search.SearchArtist
import com.escodro.savel.data.remote.musicbrainz.model.artist.Artist
import com.escodro.savel.data.remote.musicbrainz.model.artist.Relation

internal class ArtistMapper(
    private val externalResourceMapper: ExternalResourceMapper,
) {
    fun toCore(
        artist: Artist,
        relationList: List<Relation>?,
    ): SearchArtist =
        SearchArtist(
            id = artist.id,
            name = artist.name,
            imageId = relationList?.let { list -> externalResourceMapper.toArtistImageId(list) },
            // MusicBrainz API does not provide the image URL
            imageUrl = null,
        )

    fun toFullArtist(artist: Artist): FullArtist =
        FullArtist(
            id = artist.id,
            name = artist.name,
            imageId = artist.relations?.let { list -> externalResourceMapper.toArtistImageId(list) },
            // MusicBrainz API does not provide the image URL
            imageUrl = null,
            externalResources = externalResourceMapper.toExternalResourceList(artist.relations),
        )
}
