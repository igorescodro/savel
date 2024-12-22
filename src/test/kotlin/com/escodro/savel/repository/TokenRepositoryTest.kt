package com.escodro.savel.repository

import com.escodro.savel.core.model.artist.ExternalProvider
import com.escodro.savel.data.repository.TokenRepositoryImpl
import com.escodro.savel.data.repository.model.Token
import com.escodro.savel.repository.fake.DateTimeProviderFake
import com.escodro.savel.repository.fake.RetrieveTokenDataSourceFake
import com.escodro.savel.repository.fake.StoreTokenDataSourceFake
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class TokenRepositoryTest {
    private val retrieveTokenDataSource = RetrieveTokenDataSourceFake()

    private val saveTokenDataSource = StoreTokenDataSourceFake()

    private val dateTimeProvider = DateTimeProviderFake()

    private val tokenRepository =
        TokenRepositoryImpl(
            retrieveTokenDataSource = retrieveTokenDataSource,
            storeTokenDataSource = saveTokenDataSource,
            dateTimeProvider = dateTimeProvider,
        )

    @BeforeTest
    fun setup() {
        retrieveTokenDataSource.clear()
        saveTokenDataSource.clear()
        dateTimeProvider.clear()
    }

    @Test
    fun `when the token is refreshed, then the new token is saved`() =
        runTest {
            // Given a token is retrieved
            val expectedToken =
                Token(
                    value = "my-little-token",
                    provider = ExternalProvider.Spotify,
                    expiresAt = Instant.fromEpochMilliseconds(0),
                )
            retrieveTokenDataSource.token = expectedToken

            // When the use case is called
            tokenRepository.refreshToken()

            // Then the token is saved
            val savedToken = saveTokenDataSource.token
            assertEquals(expectedToken, savedToken)
        }

    @Test
    fun `when the token is null, then the token is not saved`() =
        runTest {
            // Given a token is not retrieved
            retrieveTokenDataSource.token = null

            // When the use case is called
            tokenRepository.refreshToken()

            // Then the token is not saved
            val savedToken = saveTokenDataSource.token
            assertNull(savedToken)
        }

    @Test
    fun `when the token is not expired, then the token is not refreshed`() =
        runTest {
            // Given the token is not expired
            dateTimeProvider.currentTime = 100

            val savedToken =
                Token(
                    value = "saved-token",
                    provider = ExternalProvider.Spotify,
                    expiresAt = Instant.fromEpochMilliseconds(200),
                )
            saveTokenDataSource.token = savedToken

            val newToken =
                Token(
                    value = "new-token",
                    provider = ExternalProvider.Spotify,
                    expiresAt = Instant.fromEpochMilliseconds(200),
                )
            retrieveTokenDataSource.token = newToken

            // when the use case is called
            tokenRepository.refreshToken()

            // Then the token is not refreshed
            val currentToken = saveTokenDataSource.token
            assertEquals(savedToken, currentToken)
        }

    @Test
    fun `when the token is expired, then the token is refreshed`() =
        runTest {
            // Given the token is expired
            dateTimeProvider.currentTime = 100

            val savedToken =
                Token(
                    value = "saved-token",
                    provider = ExternalProvider.Spotify,
                    expiresAt = Instant.fromEpochMilliseconds(50),
                )
            saveTokenDataSource.token = savedToken

            val newToken =
                Token(
                    value = "new-token",
                    provider = ExternalProvider.Spotify,
                    expiresAt = Instant.fromEpochMilliseconds(200),
                )
            retrieveTokenDataSource.token = newToken

            // when the use case is called
            tokenRepository.refreshToken()

            // Then the token is refreshed
            val currentToken = saveTokenDataSource.token
            assertEquals(newToken, currentToken)
        }
}
