package com.escodro.savel.data.local.dao

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.data.local.mapper.ArtistMapper
import com.escodro.savel.data.repository.datasource.StoreArtistDataSource
import com.google.cloud.firestore.Firestore

internal class ArtistDao(
    private val firestore: Firestore,
    private val artistMapper: ArtistMapper,
) : StoreArtistDataSource {
    override fun saveArtist(artist: FullArtist): Boolean {
        val localArtist = artistMapper.toLocal(artist)

        if (localArtist.id.isNullOrEmpty() || localArtist.name.isNullOrEmpty()) {
            return false
        }
        firestore.collection(COLLECTION_NAME).document(localArtist.id).set(localArtist)
        return true
    }

    private companion object {
        private const val COLLECTION_NAME = "artist"
    }
}
