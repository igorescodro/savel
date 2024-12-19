package com.escodro.savel.data.repository.datasource

import com.escodro.savel.core.model.Artist

internal interface ArtistDataSource {

    suspend fun searchArtist(name: String): List<Artist>
}