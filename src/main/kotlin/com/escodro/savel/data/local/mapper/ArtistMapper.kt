package com.escodro.savel.data.local.mapper

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.data.local.model.Artist

internal class ArtistMapper {
    fun toLocal(
        artist: FullArtist,
        ttl: Long,
    ): Artist =
        Artist(
            id = artist.id,
            name = artist.name,
            imageUrl = artist.imageUrl?.imageUrl,
            externalResources = artist.externalResources,
            timeToLive = ttl,
        )
}
