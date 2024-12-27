package com.escodro.savel.domain.repository

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.domain.model.SearchArtistResponse

internal interface ArtistRepository {
    suspend fun searchArtist(name: String): SearchArtistResponse

    suspend fun getArtistById(artistId: String): FullArtist
}
