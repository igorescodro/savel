package com.escodro.savel.data.remote.mapper

import com.escodro.savel.core.model.Artist as CoreArtist
import com.escodro.savel.data.remote.model.artist.Artist as RemoteArtist

internal class ArtistMapper {

    fun toCore(artistList: List<RemoteArtist>): List<CoreArtist> =
        artistList.map { artist ->
            CoreArtist(
                id = artist.id,
                name = artist.name,
                country = artist.country
            )
        }
}