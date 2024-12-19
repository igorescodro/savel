package com.escodro.savel.data.remote.di

import com.escodro.savel.data.remote.MusicBrainzApiImpl
import com.escodro.savel.data.remote.client.SavelHttpClient
import com.escodro.savel.data.repository.datasource.MusicBrainzApi
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    factoryOf(::MusicBrainzApiImpl) bind MusicBrainzApi::class

    singleOf(::SavelHttpClient)
}