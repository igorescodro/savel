package com.escodro.savel.core.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class FullArtist(
    @SerialName("id") override val id: String?,
    @SerialName("name") override val name: String?,
    @Transient override val imageId: String? = null,
    @SerialName("image_url") override val imageUrl: ArtistImage?,
    @SerialName("external_resources") val externalResources: List<ExternalResource>?,
) : CoreArtist
