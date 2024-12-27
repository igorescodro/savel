package com.escodro.savel.data.remote.musicbrainz.mapper

import com.escodro.savel.core.model.artist.ExternalResource
import com.escodro.savel.core.model.provider.ExternalProvider
import com.escodro.savel.data.remote.musicbrainz.model.artist.Relation

internal class ExternalResourceMapper {
    fun toExternalResourceList(relationList: List<Relation>?): List<ExternalResource>? {
        if (relationList == null) {
            return null
        }

        return Resource.entries.flatMap { website -> relationList.getExternalResource(website = website) }
    }

    fun toArtistImageId(relationList: List<Relation>): String? =
        relationList
            .getExternalResource(Resource.SPOTIFY)
            .firstOrNull()
            ?.id

    private fun List<Relation>.getExternalResource(website: Resource): List<ExternalResource> {
        val providerList = this.filter { it.url.resource.contains(website.url) }
        return providerList.mapNotNull { relation ->
            val id =
                relation.url.resource
                    .split("/")
                    .getOrNull(website.idIndex) ?: return@mapNotNull null
            ExternalResource(provider = website.provider, id = id, url = relation.url.resource)
        }
    }

    private enum class Resource(
        val url: String,
        val provider: ExternalProvider,
        val idIndex: Int,
    ) {
        SPOTIFY(url = "open.spotify.com/artist/", provider = ExternalProvider.Spotify, idIndex = 4),
        APPLE_MUSIC(url = "music.apple.com/", provider = ExternalProvider.AppleMusic, idIndex = 5),
        INSTAGRAM(url = "instagram.com/", provider = ExternalProvider.Instagram, idIndex = 3),
        DEEZER(url = "deezer.com/", provider = ExternalProvider.Deezer, idIndex = 4),
        TIDAL(url = "tidal.com/artist/", provider = ExternalProvider.Tidal, idIndex = 4),
        YOUTUBE(url = "www.youtube.com/channel/", provider = ExternalProvider.Youtube, idIndex = 4),
        YOUTUBE_MUSIC(url = "music.youtube.com/channel/", provider = ExternalProvider.YouTubeMusic, idIndex = 4),
        AMAZON_MUSIC(url = "music.amazon.com/artists/", provider = ExternalProvider.AmazonMusic, idIndex = 4),
        TIKTOK(url = "tiktok.com/", provider = ExternalProvider.TikTok, idIndex = 3),
        FACEBOOK(url = "facebook.com/", provider = ExternalProvider.Facebook, idIndex = 3),
        THREADS(url = "threads.net/", provider = ExternalProvider.Threads, idIndex = 3),
        TWITTER(url = "twitter.com/", provider = ExternalProvider.Twitter, idIndex = 3),
    }
}
