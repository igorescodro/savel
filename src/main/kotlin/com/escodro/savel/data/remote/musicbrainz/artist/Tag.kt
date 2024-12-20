package com.escodro.savel.data.remote.musicbrainz.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("count") val count: Int,
    @SerialName("name") val name: String
)