package com.escodro.savel.data.repository.datasource

import com.escodro.savel.core.model.artist.SearchArtist

internal interface ArtistDataSource {
    suspend fun searchArtist(name: String): List<SearchArtist>
}
