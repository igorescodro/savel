package com.escodro.savel.repository.fake

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.core.model.search.SearchArtist
import com.escodro.savel.data.repository.datasource.ArtistDataSource

internal class ArtistDataSourceFake : ArtistDataSource {
    var artistList: List<SearchArtist>? = null

    var artist: FullArtist? = null

    override suspend fun searchArtist(name: String): List<SearchArtist> = artistList!!

    override suspend fun getArtistById(artistId: String): FullArtist = artist!!

    fun clear() {
        artistList = null
        artist = null
    }
}
