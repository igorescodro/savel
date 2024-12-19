package com.escodro.savel.data.repository.datasource

import com.escodro.savel.core.model.Artist

internal interface MusicBrainzApi {

    suspend fun searchArtist(name: String): List<Artist>
}