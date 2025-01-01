package com.escodro.savel.data.repository.datasource

import com.escodro.savel.core.model.artist.FullArtist

interface StoreArtistDataSource {
    fun saveArtist(artist: FullArtist): Boolean
}
