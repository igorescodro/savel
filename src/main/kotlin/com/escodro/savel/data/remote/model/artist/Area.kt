package com.escodro.savel.data.remote.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Area(
    @SerialName("id") val id: String,
    @SerialName("type") val type: String? = null,
    @SerialName("type-id") val typeId: String? = null,
    @SerialName("name") val name: String,
    @SerialName("sort-name") val sortName: String,
    @SerialName("life-span") val lifeSpan: LifeSpan? = null
)