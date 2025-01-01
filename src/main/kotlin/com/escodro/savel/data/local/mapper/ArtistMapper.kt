package com.escodro.savel.data.local.mapper

import com.escodro.savel.core.model.artist.ArtistImage
import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.data.local.model.Artist

internal class ArtistMapper(
    private val externalResourceMapper: ExternalResourceMapper,
) {
    fun toLocal(
        artist: FullArtist,
        ttlInMillis: Long,
    ): Artist =
        Artist(
            id = artist.id,
            name = artist.name,
            imageUrl = artist.imageUrl?.imageUrl,
            externalResources = externalResourceMapper.toLocal(artist.externalResources),
            ttlInMillis = ttlInMillis,
        )

    fun toCore(artist: Artist): FullArtist =
        FullArtist(
            id = artist.id,
            name = artist.name,
            imageUrl = artist.imageUrl?.let { imageUrl -> ArtistImage(imageUrl) },
            externalResources = externalResourceMapper.toCore(artist.externalResources),
            ttlInMillis = artist.ttlInMillis,
        )
}
