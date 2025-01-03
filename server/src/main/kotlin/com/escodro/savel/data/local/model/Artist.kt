package com.escodro.savel.data.local.model

import com.google.cloud.firestore.annotation.PropertyName

data class Artist(
    @get:PropertyName("id") val id: String? = null,
    @get:PropertyName("name") val name: String? = null,
    @get:PropertyName("image_url") val imageUrl: String? = null,
    @get:PropertyName("external_resources") val externalResources: List<ExternalResource>? =
        emptyList(),
    @get:PropertyName("ttl_in_millis") val ttlInMillis: Long = 0L,
)
