package com.escodro.savel.data.remote.di

import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.musicbrainz.MusicBrainzApi
import com.escodro.savel.data.remote.musicbrainz.mapper.ArtistMapper
import com.escodro.savel.data.remote.musicbrainz.mapper.ExternalResourceMapper
import com.escodro.savel.data.repository.datasource.ArtistDataSource
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    // Client
    singleOf(::SavelHttpClient)

    // MusicBrainz
    factoryOf(::MusicBrainzApi) bind ArtistDataSource::class

    factoryOf(::ArtistMapper)
    factoryOf(::ExternalResourceMapper)
}