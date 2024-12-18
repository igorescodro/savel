package com.escodro.domain.repository

import com.escodro.domain.model.SearchArtistResponse

internal interface ArtistRepository {

    suspend fun searchArtist(name: String): SearchArtistResponse
}