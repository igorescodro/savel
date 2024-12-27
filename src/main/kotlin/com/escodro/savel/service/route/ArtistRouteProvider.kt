package com.escodro.savel.service.route

import com.escodro.savel.core.model.artist.FullArtist
import com.escodro.savel.domain.usecase.artist.GetArtistById
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get

internal class ArtistRouteProvider(
    private val getArtistById: GetArtistById,
) : RouteProvider {
    override val routes: Routing.() -> Unit = {
        get("/artists/{id}") {
            val id = call.parameters["id"]
            val artist: Result<FullArtist> = getArtistById(artistId = id)
            call.respond(artist.getOrThrow())
        }
    }
}
