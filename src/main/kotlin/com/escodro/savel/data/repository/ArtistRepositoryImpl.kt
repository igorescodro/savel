package com.escodro.savel.data.repository

import com.escodro.savel.core.model.artist.Artist
import com.escodro.savel.core.model.artist.ExternalProvider
import com.escodro.savel.data.repository.datasource.ArtistDataSource
import com.escodro.savel.data.repository.datasource.ArtistImageDataSource
import com.escodro.savel.domain.model.SearchArtistResponse
import com.escodro.savel.domain.repository.ArtistRepository
import com.escodro.savel.domain.repository.TokenRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

internal class ArtistRepositoryImpl(
    private val artistDataSource: ArtistDataSource,
    private val artistImageDataSource: ArtistImageDataSource,
    private val tokenRepository: TokenRepository,
) : ArtistRepository {
    override suspend fun searchArtist(name: String): SearchArtistResponse =
        coroutineScope {
            tokenRepository.refreshToken()
            val artistList = artistDataSource.searchArtist(name)
            val updatedArtistList = artistList.map { artist -> updateArtistWithImage(artist) }.awaitAll()
            SearchArtistResponse(artists = updatedArtistList)
        }

    private fun CoroutineScope.updateArtistWithImage(artist: Artist) =
        async {
            artist.externalResourceList.find { it.provider == ExternalProvider.Spotify }?.let {
                val imageUrl = artistImageDataSource.getArtistImage(it.id)
                artist.copy(imageUrl = imageUrl)
            } ?: artist
        }
}
