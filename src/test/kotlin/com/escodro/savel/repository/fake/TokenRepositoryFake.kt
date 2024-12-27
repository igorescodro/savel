package com.escodro.savel.repository.fake

import com.escodro.savel.domain.repository.TokenRepository

internal class TokenRepositoryFake : TokenRepository {
    var wasCalled: Boolean = false

    override suspend fun refreshToken() {
        wasCalled = true
    }

    fun clear() {
        wasCalled = false
    }
}
