package com.escodro.savel.repository

import com.escodro.savel.data.repository.ArtistRepositoryImpl
import com.escodro.savel.repository.factory.ArtistFactory
import com.escodro.savel.repository.fake.ArtistDataSourceFake
import com.escodro.savel.repository.fake.ArtistImageDataSourceFake
import com.escodro.savel.repository.fake.StoreArtistDataSourceFake
import com.escodro.savel.repository.fake.TokenRepositoryFake
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Clock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.days

internal class ArtistRepositoryTest {
    private val artistDataSource = ArtistDataSourceFake()

    private val artistImageDataSource = ArtistImageDataSourceFake()

    private val tokenRepository = TokenRepositoryFake()

    private val storeArtistDataSource = StoreArtistDataSourceFake()

    private val artistRepository =
        ArtistRepositoryImpl(
            artistDataSource = artistDataSource,
            artistImageDataSource = artistImageDataSource,
            storeArtistDataSource = storeArtistDataSource,
            tokenRepository = tokenRepository,
        )

    @BeforeTest
    fun setup() {
        artistDataSource.clear()
        artistImageDataSource.clear()
        storeArtistDataSource.clear()
        tokenRepository.clear()
    }

    @Test
    fun `when search artist then return list of artists`() =
        runTest {
            // Given
            val artist1 = ArtistFactory.createSearchArtist()
            val artist2 = ArtistFactory.createSearchArtist()
            artistDataSource.artistList = listOf(artist1, artist2)

            // When
            val result = artistRepository.searchArtist("artist")

            // Then
            assertEquals(2, result.artists.size)
            assertEquals(artist1, result.artists.first())
            assertEquals(artist2, result.artists.last())
        }

    @Test
    fun `when search artist has image id then the get artist image is called`() =
        runTest {
            // Given
            val artist = ArtistFactory.createSearchArtist(imageId = "imageId")
            artistDataSource.artistList = listOf(artist)

            // When
            val result = artistRepository.searchArtist("artist")

            // Then
            assertEquals(1, result.artists.size)
            assertTrue(artistImageDataSource.wasCalled)
        }

    @Test
    fun `when search artist has no image id then the get artist image is not called`() =
        runTest {
            // Given
            val artist = ArtistFactory.createSearchArtist(imageId = null)
            artistDataSource.artistList = listOf(artist)

            // When
            val result = artistRepository.searchArtist("artist")

            // Then
            assertEquals(1, result.artists.size)
            assertTrue(!artistImageDataSource.wasCalled)
        }

    @Test
    fun `when search artist then list is sorted by if artist has image`() =
        runTest {
            // Given
            val artist1 = ArtistFactory.createSearchArtist(imageId = "imageId")
            val artist2 = ArtistFactory.createSearchArtist(imageId = null)
            val artist3 = ArtistFactory.createSearchArtist(imageId = "imageId")
            artistDataSource.artistList = listOf(artist1, artist2, artist3)

            // When
            val result = artistRepository.searchArtist("artist")

            // Then
            assertEquals(3, result.artists.size)

            // Comparing the names because the image is added by the repository
            assertEquals(artist1.name, result.artists[0].name)
            assertEquals(artist3.name, result.artists[1].name)
            assertEquals(artist2.name, result.artists[2].name)
        }

    @Test
    fun `when search artist then refresh token is called`() {
        runTest {
            // Given
            val artist = ArtistFactory.createSearchArtist()
            artistDataSource.artistList = listOf(artist)

            // When
            artistRepository.searchArtist("artist")

            // Then
            assertTrue(tokenRepository.wasCalled)
        }
    }

    @Test
    fun `when get artist by id then return artist`() =
        runTest {
            // Given
            val artist = ArtistFactory.createFullArtist()
            artistDataSource.artist = artist

            // When
            val result = artistRepository.getArtistById("artistId")

            // Then
            assertEquals(artist, result)
        }

    @Test
    fun `when get artist is called then refresh token is called`() {
        runTest {
            // Given
            val artist = ArtistFactory.createFullArtist()
            artistDataSource.artist = artist

            // When
            artistRepository.getArtistById("artistId")

            // Then
            assertTrue(tokenRepository.wasCalled)
        }
    }

    @Test
    fun `when the artist is fetch then the artist is saved in the store`() {
        runTest {
            // Given
            val artist = ArtistFactory.createFullArtist(id = "ts-13")
            artistDataSource.artist = artist

            // When
            artistRepository.getArtistById("ts-13")

            // Then
            assertEquals(1, storeArtistDataSource.artistMap.size)
            assertEquals(artist, storeArtistDataSource.artistMap["ts-13"])
        }
    }

    @Test
    fun `when the cache is expired then a refresh artist info is returned`() {
        runTest {
            // Given
            val ttl = (Clock.System.now() - 1.days).toEpochMilliseconds()
            val artist = ArtistFactory.createFullArtist(id = "ftp-2012", timeToLive = ttl)
            artistDataSource.artist = artist

            // When
            val result = artistRepository.getArtistById("ftp-2012")

            // Then
            assertEquals(artist, result)
            assertTrue(tokenRepository.wasCalled)
        }
    }

    @Test
    fun `when the cache is valid then the artist is returned from the store`() {
        runTest {
            // Given
            val ttl = (Clock.System.now() + 1.days).toEpochMilliseconds()
            val artist = ArtistFactory.createFullArtist(id = "lp-2005", timeToLive = ttl)
            storeArtistDataSource.artistMap = mapOf("lp-2005" to artist)

            // When
            val result = artistRepository.getArtistById("lp-2005")

            // Then
            assertEquals(artist, result)
            assertFalse(tokenRepository.wasCalled)
            assertNull(artistDataSource.artist)
        }
    }
}
