package com.escodro.savel.data.remote.musicbrainz.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Alias(
    @SerialName("sort-name") val sortName: String,
    @SerialName("type-id") val typeId: String? = null,
    @SerialName("name") val name: String,
    @SerialName("locale") val locale: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("primary") val primary: Boolean? = null,
    @SerialName("begin-date") val beginDate: String? = null,
    @SerialName("end-date") val endDate: String? = null
)