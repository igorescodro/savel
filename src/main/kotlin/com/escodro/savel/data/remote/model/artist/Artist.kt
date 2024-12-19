package com.escodro.savel.data.remote.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("id") val id: String,
    @SerialName("type") val type: String? = null,
    @SerialName("type-id") val typeId: String? = null,
    @SerialName("score") val score: Int? = null,
    @SerialName("gender-id") val genderId: String? = null,
    @SerialName("name") val name: String,
    @SerialName("sort-name") val sortName: String? = null,
    @SerialName("gender") val gender: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("area") val area: Area? = null,
    @SerialName("begin-area") val beginArea: Area? = null,
    @SerialName("ipis") val ipis: List<String>? = null,
    @SerialName("isnis") val isnis: List<String>? = null,
    @SerialName("life-span") val lifeSpan: LifeSpan? = null,
    @SerialName("aliases") val aliases: List<Alias>? = null,
    @SerialName("tags") val tags: List<Tag>? = null
)
