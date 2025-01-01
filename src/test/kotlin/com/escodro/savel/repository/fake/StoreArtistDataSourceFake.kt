package com.escodro.savel.repository.fake

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.data.repository.datasource.StoreArtistDataSource

internal class StoreArtistDataSourceFake : StoreArtistDataSource {
    var artistMap = emptyMap<String, FullArtist>()

    override fun saveArtist(artist: FullArtist): Boolean {
        artistMap = artistMap.plus(artist.id!! to artist)
        return true
    }

    override fun getArtistById(artistId: String): FullArtist? = artistMap[artistId]

    fun clear() {
        artistMap = emptyMap()
    }
}
