package com.escodro.savel.repository.fake

import com.escodro.savel.domain.repository.TokenRepository

internal class TokenRepositoryFake : TokenRepository {
    override suspend fun refreshToken() {
        // Do nothing
    }
}
