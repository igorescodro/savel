package com.escodro.savel.core.model.search

import com.escodro.savel.core.model.artist.ArtistImage
import com.escodro.savel.core.model.artist.CoreArtist
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
internal data class SearchArtist(
    @SerialName("id") override val id: String?,
    @SerialName("name") override val name: String?,
    @Transient override val imageId: String? = null,
    @SerialName("image_url") override val imageUrl: ArtistImage?,
) : CoreArtist
