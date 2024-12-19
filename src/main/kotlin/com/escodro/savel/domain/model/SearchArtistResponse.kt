package com.escodro.savel.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchArtistResponse(
    @SerialName("artists") val artists: List<Artist>
)