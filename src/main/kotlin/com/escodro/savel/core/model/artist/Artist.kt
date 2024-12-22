package com.escodro.savel.core.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Artist(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?,
    @SerialName("external_ids") val externalResourceList: List<ExternalResource>,
    @SerialName("image_url") val imageUrl: ArtistImage?,
)
