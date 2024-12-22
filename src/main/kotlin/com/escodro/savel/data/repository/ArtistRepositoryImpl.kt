package com.escodro.savel.data.repository

import com.escodro.savel.data.repository.datasource.ArtistDataSource
import com.escodro.savel.domain.model.SearchArtistResponse
import com.escodro.savel.domain.repository.ArtistRepository
import com.escodro.savel.domain.repository.TokenRepository

internal class ArtistRepositoryImpl(
    private val artistDataSource: ArtistDataSource,
    private val tokenRepository: TokenRepository,
) : ArtistRepository {
    override suspend fun searchArtist(name: String): SearchArtistResponse {
        tokenRepository.refreshToken()
        return SearchArtistResponse(
            artists = artistDataSource.searchArtist(name = name),
        )
    }
}
