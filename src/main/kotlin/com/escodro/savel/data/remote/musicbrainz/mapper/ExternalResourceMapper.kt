package com.escodro.savel.data.remote.musicbrainz.mapper

import com.escodro.savel.core.model.artist.ExternalResource
import com.escodro.savel.core.model.provider.ExternalProvider
import com.escodro.savel.data.remote.musicbrainz.model.artist.Relation

internal class ExternalResourceMapper {
    fun toExternalResourceList(relationList: List<Relation>?): List<ExternalResource>? {
        if (relationList == null) {
            return null
        }

        return with(relationList) {
            listOfNotNull(
                getExternalResource(mask = SPOTIFY_MASK, provider = ExternalProvider.Spotify, idIndex = 4),
                getExternalResource(mask = APPLE_MUSIC_MASK, provider = ExternalProvider.AppleMusic, idIndex = 5),
                getExternalResource(mask = INSTAGRAM_MASK, provider = ExternalProvider.Instagram, idIndex = 3),
                getExternalResource(mask = DEEZER_MASK, provider = ExternalProvider.Deezer, idIndex = 4),
                getExternalResource(mask = TIDAL_MASK, provider = ExternalProvider.Tidal, idIndex = 4),
                getExternalResource(mask = YOUTUBE_MASK, provider = ExternalProvider.Youtube, idIndex = 4),
                getExternalResource(mask = YOUTUBE_MUSIC_MASK, provider = ExternalProvider.YouTubeMusic, idIndex = 4),
                getExternalResource(mask = AMAZON_MUSIC_MASK, provider = ExternalProvider.AmazonMusic, idIndex = 4),
                getExternalResource(mask = TIKTOK_MASK, provider = ExternalProvider.TikTok, idIndex = 3),
                getExternalResource(mask = FACEBOOK_MASK, provider = ExternalProvider.Facebook, idIndex = 3),
                getExternalResource(mask = THREADS_MASK, provider = ExternalProvider.Threads, idIndex = 3),
                getExternalResource(mask = TWITTER_MASK, provider = ExternalProvider.Twitter, idIndex = 3),
            ).flatten()
        }
    }

    fun toArtistImageId(relationList: List<Relation>): String? =
        relationList
            .getExternalResource(mask = SPOTIFY_MASK, provider = ExternalProvider.Spotify, idIndex = 4)
            .firstOrNull()
            ?.id

    private fun List<Relation>.getExternalResource(
        mask: String,
        provider: ExternalProvider,
        idIndex: Int,
    ): List<ExternalResource> {
        val providerList = this.filter { it.url.resource.contains(mask) }
        return providerList.mapNotNull { relation ->
            val id =
                relation.url.resource
                    .split("/")
                    .getOrNull(idIndex) ?: return@mapNotNull null
            ExternalResource(provider = provider, id = id, url = relation.url.resource)
        }
    }

    private companion object {
        const val SPOTIFY_MASK = "open.spotify.com/artist/"
        const val APPLE_MUSIC_MASK = "music.apple.com/"
        const val INSTAGRAM_MASK = "instagram.com/"
        const val DEEZER_MASK = "deezer.com/"
        const val TIDAL_MASK = "tidal.com/artist/"
        const val YOUTUBE_MASK = "www.youtube.com/channel/"
        const val YOUTUBE_MUSIC_MASK = "music.youtube.com/channel/"
        const val AMAZON_MUSIC_MASK = "music.amazon.com/artists/"
        const val TIKTOK_MASK = "tiktok.com/"
        const val FACEBOOK_MASK = "facebook.com/"
        const val THREADS_MASK = "threads.net/"
        const val TWITTER_MASK = "twitter.com/"
    }
}
