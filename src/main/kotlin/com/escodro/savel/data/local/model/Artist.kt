package com.escodro.savel.data.local.model

internal data class Artist(
    val id: String? = null,
    val name: String? = null,
    val imageUrl: String? = null,
    val externalResources: List<ExternalResource>? = emptyList(),
    val timeToLive: Long = 0L,
)
