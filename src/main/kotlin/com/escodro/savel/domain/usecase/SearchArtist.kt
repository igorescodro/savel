package com.escodro.savel.domain.usecase

import com.escodro.savel.domain.model.SearchArtistResponse
import com.escodro.savel.domain.repository.ArtistRepository
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