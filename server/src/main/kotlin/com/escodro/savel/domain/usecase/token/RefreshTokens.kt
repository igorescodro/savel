package com.escodro.savel.domain.usecase.token

import com.escodro.savel.domain.repository.TokenRepository

internal class RefreshTokens(
    private val tokenRepository: TokenRepository,
) {
    suspend operator fun invoke() {
        tokenRepository.refreshToken()
    }
}
