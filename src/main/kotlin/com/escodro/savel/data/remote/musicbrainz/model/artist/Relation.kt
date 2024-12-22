package com.escodro.savel.data.remote.musicbrainz.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Relation(
    @SerialName("url") val url: Url,
    @SerialName("attribute-values") val attributeValues: Map<String, String>? = null,
    @SerialName("attribute-ids") val attributeIds: Map<String, String>? = null,
    @SerialName("ended") val ended: Boolean? = null,
    @SerialName("target-credit") val targetCredit: String? = null,
    @SerialName("direction") val direction: String? = null,
    @SerialName("target-type") val targetType: String? = null,
    @SerialName("attributes") val attributes: List<String>? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("begin") val begin: String? = null,
    @SerialName("source-credit") val sourceCredit: String? = null,
    @SerialName("end") val end: String? = null,
    @SerialName("type-id") val typeId: String? = null,
)
