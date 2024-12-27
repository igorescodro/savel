package com.escodro.savel.data.repository.datasource

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.core.model.search.SearchArtist

internal interface ArtistDataSource {
    suspend fun searchArtist(name: String): List<SearchArtist>

    suspend fun getArtistById(artistId: String): FullArtist
}
