package com.escodro.savel.repository.factory

import com.escodro.savel.core.model.artist.ArtistImage
import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.core.model.search.SearchArtist
import kotlin.random.Random

internal object ArtistFactory {
    fun createSearchArtist(
        id: String = "artist_${Random.nextInt()}",
        name: String = "Artist ${Random.nextInt()}",
        imageId: String? = null,
        imageUrl: String? = if (imageId != null) "https://image.com/imageId" else null,
    ): SearchArtist =
        SearchArtist(
            id = id,
            name = name,
            imageId = imageId,
            imageUrl = ArtistImage(imageUrl = imageUrl),
        )

    fun createFullArtist(
        id: String = "artist_${Random.nextInt()}",
        name: String = "Artist ${Random.nextInt()}",
        imageUrl: String? = null,
        timeToLive: Long? = null,
    ): FullArtist =
        FullArtist(
            id = id,
            name = name,
            imageUrl = ArtistImage(imageUrl = imageUrl),
            externalResources = emptyList(),
            timeToLive = timeToLive,
        )
}
