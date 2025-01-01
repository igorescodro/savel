package com.escodro.savel.data.local.model

import com.escodro.savel.core.model.artist.ExternalResource

internal data class Artist(
    val id: String?,
    val name: String?,
    val imageUrl: String?,
    val externalResources: List<ExternalResource>?,
    val timeToLive: Long,
)
