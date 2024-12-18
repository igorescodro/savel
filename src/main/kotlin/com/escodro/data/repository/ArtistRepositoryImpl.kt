package com.escodro.data.repository

import com.escodro.data.repository.datasource.MusicBrainzApi
import com.escodro.domain.model.SearchArtistResponse
import com.escodro.domain.repository.ArtistRepository

internal class ArtistRepositoryImpl(
    private val musicBrainzApi: MusicBrainzApi,
) : ArtistRepository {

    override suspend fun searchArtist(name: String): SearchArtistResponse =
        musicBrainzApi.searchArtist(name = name)
}