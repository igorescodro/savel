package com.escodro.data.repository.datasource

import com.escodro.domain.model.SearchArtistResponse

internal interface MusicBrainzApi {

    suspend fun searchArtist(name: String): SearchArtistResponse
}