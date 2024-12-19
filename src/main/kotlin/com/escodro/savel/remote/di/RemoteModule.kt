package com.escodro.savel.remote.di

import com.escodro.savel.data.repository.datasource.MusicBrainzApi
import com.escodro.savel.remote.MusicBrainzApiImpl
import com.escodro.savel.remote.client.SavelHttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    factoryOf(::MusicBrainzApiImpl) bind MusicBrainzApi::class

    singleOf(::SavelHttpClient)
}