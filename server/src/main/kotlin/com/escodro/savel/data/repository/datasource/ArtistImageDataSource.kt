package com.escodro.savel.data.repository.datasource

import com.escodro.savel.core.model.artist.ArtistImage

internal interface ArtistImageDataSource {
    suspend fun getArtistImage(artistId: String): ArtistImage
}
