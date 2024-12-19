package com.escodro.savel.data.remote.di

import com.escodro.savel.data.remote.MusicBrainzApi
import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.remote.mapper.ArtistMapper
import com.escodro.savel.data.repository.datasource.ArtistDataSource
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    // APIs
    factoryOf(::MusicBrainzApi) bind ArtistDataSource::class

    // Client
    singleOf(::SavelHttpClient)

    // Mappers
    factoryOf(::ArtistMapper)
}