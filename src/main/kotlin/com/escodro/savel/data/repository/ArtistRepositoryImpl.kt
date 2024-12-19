package com.escodro.savel.data.repository

import com.escodro.savel.data.repository.datasource.ArtistDataSource
import com.escodro.savel.domain.model.SearchArtistResponse
import com.escodro.savel.domain.repository.ArtistRepository

internal class ArtistRepositoryImpl(
    private val artistDataSource: ArtistDataSource,
) : ArtistRepository {

    override suspend fun searchArtist(name: String): SearchArtistResponse =
        SearchArtistResponse(
            artists = artistDataSource.searchArtist(name = name)
        )
}