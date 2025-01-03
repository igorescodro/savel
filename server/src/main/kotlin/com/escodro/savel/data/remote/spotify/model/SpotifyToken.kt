package com.escodro.savel.data.remote.spotify.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpotifyToken(
    @SerialName("access_token") val value: String,
    @SerialName("token_type") val type: String,
    @SerialName("expires_in") val expiresInMillis: Long,
)
