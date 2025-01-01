package com.escodro.savel.data.local.dao

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.data.local.mapper.ArtistMapper
import com.escodro.savel.data.repository.datasource.StoreArtistDataSource
import com.google.cloud.firestore.Firestore
import kotlinx.datetime.Clock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days

internal class ArtistDao(
    private val firestore: Firestore,
    private val artistMapper: ArtistMapper,
) : StoreArtistDataSource {
    override fun saveArtist(artist: FullArtist): Boolean {
        val localArtist = artistMapper.toLocal(artist = artist, ttl = getTimeToLiveInMillis())

        if (localArtist.id.isNullOrEmpty() || localArtist.name.isNullOrEmpty()) {
            return false
        }
        firestore.collection(COLLECTION_NAME).document(localArtist.id).set(localArtist)
        return true
    }

    private fun getTimeToLiveInMillis(): Long =
        Clock.System
            .now()
            .plus(TTL_IN_MILLIS)
            .toEpochMilliseconds()

    private companion object {
        private const val COLLECTION_NAME = "artist"

        private val TTL_IN_MILLIS: Duration = 1.days
    }
}