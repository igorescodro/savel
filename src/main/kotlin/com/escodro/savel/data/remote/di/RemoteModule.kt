package com.escodro.savel.data.remote.di

import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.musicbrainz.MusicBrainzApi
import com.escodro.savel.data.remote.musicbrainz.mapper.ArtistMapper
import com.escodro.savel.data.remote.musicbrainz.mapper.ExternalResourceMapper
import com.escodro.savel.data.remote.spotify.ArtistImageDataSourceImpl
import com.escodro.savel.data.remote.spotify.SpotifyApi
import com.escodro.savel.data.remote.spotify.mapper.TokenMapper
import com.escodro.savel.data.repository.datasource.ArtistDataSource
import com.escodro.savel.data.repository.datasource.ArtistImageDataSource
import com.escodro.savel.data.repository.datasource.RetrieveTokenDataSource
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule =
    module {
        // Client
        singleOf(::SavelHttpClient)

        // MusicBrainz
        factoryOf(::MusicBrainzApi) bind ArtistDataSource::class

        factoryOf(::ArtistMapper)
        factoryOf(::ExternalResourceMapper)

        // Spotify API
        factoryOf(::SpotifyApi) bind RetrieveTokenDataSource::class
        factoryOf(::ArtistImageDataSourceImpl) bind ArtistImageDataSource::class

        factoryOf(::TokenMapper)
    }
