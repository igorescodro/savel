package com.escodro.savel.core.model.artist

internal interface CoreArtist {
    val id: String?
    val name: String?
    val imageId: String?
    val imageUrl: ArtistImage?
}
