package com.escodro.savel.data.remote.spotify.mapper

import com.escodro.savel.core.model.artist.ExternalProvider
import com.escodro.savel.data.remote.spotify.model.SpotifyToken
import com.escodro.savel.data.repository.model.Token
import com.escodro.savel.library.datetime.DateTimeProvider
import kotlinx.datetime.Instant
import kotlin.time.Duration.Companion.seconds

internal class TokenMapper(
    private val dateTimeProvider: DateTimeProvider,
) {
    fun toRepo(token: SpotifyToken?): Token? {
        if (token == null) return null

        val currentTime = Instant.fromEpochMilliseconds(dateTimeProvider.getCurrentTimeInMillis())
        val expiresAt = token.expiresInMillis.seconds
        val expirationTime = currentTime + expiresAt

        return Token(
            value = "${token.type} ${token.value}",
            provider = ExternalProvider.Spotify,
            expiresAt = expirationTime,
        )
    }
}
