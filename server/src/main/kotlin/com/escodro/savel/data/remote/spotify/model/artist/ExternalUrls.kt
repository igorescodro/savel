package com.escodro.savel.data.remote.spotify.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalUrls(
    @SerialName("spotify")
    val spotify: String,
)
