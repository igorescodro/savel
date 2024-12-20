package com.escodro.savel.core.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalResource(
    @SerialName("provider") val provider: ExternalProvider,
    @SerialName("id") val id: String,
    @SerialName("url") val url: String?,
)
