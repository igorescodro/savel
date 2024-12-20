package com.escodro.savel.data.remote.musicbrainz.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LifeSpan(
    @SerialName("begin") val begin: String? = null,
    @SerialName("ended") val ended: Boolean? = null
)