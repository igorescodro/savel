package com.escodro.remote.di

import com.escodro.data.repository.datasource.MusicBrainzApi
import com.escodro.remote.MusicBrainzApiImpl
import com.escodro.remote.client.SavelHttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    factoryOf(::MusicBrainzApiImpl) bind MusicBrainzApi::class

    singleOf(::SavelHttpClient)
}