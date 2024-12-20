package com.escodro.savel.data.repository

import com.escodro.savel.data.repository.datasource.RetrieveTokenDataSource
import com.escodro.savel.data.repository.datasource.SaveTokenDataSource
import com.escodro.savel.data.repository.model.Token
import com.escodro.savel.domain.repository.TokenRepository
import com.escodro.savel.library.datetime.DateTimeProvider

internal class TokenRepositoryImpl(
    private val retrieveTokenDataSource: RetrieveTokenDataSource,
    private val saveTokenDataSource: SaveTokenDataSource,
    private val dateTimeProvider: DateTimeProvider,
) : TokenRepository {
    override suspend fun refreshToken() {
        val currentToken = saveTokenDataSource.getToken()
        if (currentToken == null || isTokenExpired(currentToken)) {
            retrieveTokenDataSource.refreshToken()?.let { saveTokenDataSource.saveToken(it) }
        }
    }

    private fun isTokenExpired(currentToken: Token) =
        currentToken.expiresAt.toEpochMilliseconds() <= dateTimeProvider.getCurrentTimeInMillis()
}
