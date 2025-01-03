package com.escodro.savel.domain.usecase.artist

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.domain.repository.ArtistRepository
import io.ktor.server.plugins.BadRequestException

internal class GetArtistById(
    private val artistRepository: ArtistRepository,
) {
    suspend operator fun invoke(artistId: String?): Result<FullArtist> {
        if (artistId == null) {
            return Result.failure(BadRequestException("The artist id cannot be empty"))
        }
        return Result.success(artistRepository.getArtistById(artistId))
    }
}
