package com.escodro.savel.data.repository.datasource

import com.escodro.savel.domain.model.SearchArtistResponse

internal interface MusicBrainzApi {

    suspend fun searchArtist(name: String): SearchArtistResponse
}