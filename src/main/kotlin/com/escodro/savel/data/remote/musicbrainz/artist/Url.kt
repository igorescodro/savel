package com.escodro.savel.data.remote.musicbrainz.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Url(
    @SerialName("resource") val resource: String,
    @SerialName("id") val id: String,
)
