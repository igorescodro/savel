package com.escodro.savel.domain.repository

internal interface TokenRepository {
    suspend fun refreshToken()
}
