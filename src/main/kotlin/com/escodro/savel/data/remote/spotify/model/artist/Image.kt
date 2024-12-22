package com.escodro.savel.data.remote.spotify.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName("url")
    val url: String,
    @SerialName("height")
    val height: Int,
    @SerialName("width")
    val width: Int,
)
