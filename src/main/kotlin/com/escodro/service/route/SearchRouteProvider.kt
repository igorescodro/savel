package com.escodro.service.route

import com.escodro.domain.model.SearchArtistResponse
import com.escodro.domain.usecase.SearchArtist
import io.ktor.server.response.*
import io.ktor.server.routing.*

internal class SearchRouteProvider(
    private val searchArtist: SearchArtist,
) : RouteProvider {

    override val routes: Routing.() -> Unit = {
        get("/search/{query}") {
            val searchResult: Result<SearchArtistResponse> = searchArtist(name = call.parameters["query"])
            call.respond(searchResult.getOrThrow())
        }
    }
}