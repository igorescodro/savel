package com.escodro.domain.usecase

import com.escodro.domain.model.SearchArtistResponse
import com.escodro.domain.repository.ArtistRepository
import io.ktor.server.plugins.*

internal class SearchArtist(
    private val artistRepository: ArtistRepository,
) {

    suspend operator fun invoke(name: String?): Result<SearchArtistResponse> {
        if (name.isNullOrEmpty()) {
            return Result.failure(BadRequestException("The artist name cannot be empty"))
        }
        return Result.success(artistRepository.searchArtist(name))
    }
}