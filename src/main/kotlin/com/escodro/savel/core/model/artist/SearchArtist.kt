package com.escodro.savel.core.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
internal data class SearchArtist(
    @SerialName("id") override val id: String?,
    @SerialName("name") override val name: String?,
    @Transient val imageId: String? = null,
    @SerialName("image_url") override val imageUrl: ArtistImage?,
) : CoreArtist
