package com.escodro.savel.data.remote.musicbrainz.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchArtistResponse(
    @SerialName("created") val created: String,
    @SerialName("count") val count: Int,
    @SerialName("offset") val offset: Int,
    @SerialName("artists") val artists: List<Artist>,
)
