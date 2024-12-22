package com.escodro.savel.data.repository

import com.escodro.savel.data.repository.datasource.RetrieveTokenDataSource
import com.escodro.savel.data.repository.datasource.StoreTokenDataSource
import com.escodro.savel.data.repository.model.Token
import com.escodro.savel.domain.repository.TokenRepository
import com.escodro.savel.library.datetime.DateTimeProvider

internal class TokenRepositoryImpl(
    private val retrieveTokenDataSource: RetrieveTokenDataSource,
    private val storeTokenDataSource: StoreTokenDataSource,
    private val dateTimeProvider: DateTimeProvider,
) : TokenRepository {
    override suspend fun refreshToken() {
        val currentToken = storeTokenDataSource.getToken()
        if (currentToken == null || isTokenExpired(currentToken)) {
            retrieveTokenDataSource.refreshToken()?.let { storeTokenDataSource.saveToken(it) }
        }
    }

    private fun isTokenExpired(currentToken: Token) =
        currentToken.expiresAt.toEpochMilliseconds() <= dateTimeProvider.getCurrentTimeInMillis()
}
