package com.escodro.savel.data.repository

import com.escodro.savel.data.repository.datasource.MusicBrainzApi
import com.escodro.savel.domain.model.SearchArtistResponse
import com.escodro.savel.domain.repository.ArtistRepository

internal class ArtistRepositoryImpl(
    private val musicBrainzApi: MusicBrainzApi,
) : ArtistRepository {

    override suspend fun searchArtist(name: String): SearchArtistResponse =
        musicBrainzApi.searchArtist(name = name)
}