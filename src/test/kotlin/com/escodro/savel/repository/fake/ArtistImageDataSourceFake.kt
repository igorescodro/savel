package com.escodro.savel.repository.fake

import com.escodro.savel.core.model.artist.ArtistImage
import com.escodro.savel.data.repository.datasource.ArtistImageDataSource

internal class ArtistImageDataSourceFake : ArtistImageDataSource {
    var wasCalled = false

    override suspend fun getArtistImage(artistId: String): ArtistImage {
        wasCalled = true
        return ArtistImage(imageUrl = artistId)
    }

    fun clear() {
        wasCalled = false
    }
}
