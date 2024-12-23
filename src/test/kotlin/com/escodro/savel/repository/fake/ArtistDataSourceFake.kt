package com.escodro.savel.repository.fake

import com.escodro.savel.core.model.artist.SearchArtist
import com.escodro.savel.data.repository.datasource.ArtistDataSource

internal class ArtistDataSourceFake : ArtistDataSource {
    var artistList: List<SearchArtist>? = null

    override suspend fun searchArtist(name: String): List<SearchArtist> = artistList!!

    fun clear() {
        artistList = null
    }
}
