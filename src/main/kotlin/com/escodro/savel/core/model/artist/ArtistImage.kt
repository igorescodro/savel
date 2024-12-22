package com.escodro.savel.core.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class ArtistImage(
    @SerialName("image_url") val imageUrl: String?,
)
