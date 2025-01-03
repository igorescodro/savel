package com.escodro.savel.data.remote.spotify.model.artist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistResponse(
    @SerialName("external_urls")
    val externalUrls: ExternalUrls,
    @SerialName("followers")
    val followers: Followers,
    @SerialName("genres")
    val genres: List<String>,
    @SerialName("href")
    val href: String,
    @SerialName("id")
    val id: String,
    @SerialName("images")
    val images: List<Image>,
    @SerialName("name")
    val name: String,
    @SerialName("popularity")
    val popularity: Int,
    @SerialName("type")
    val type: String,
    @SerialName("uri")
    val uri: String,
)
