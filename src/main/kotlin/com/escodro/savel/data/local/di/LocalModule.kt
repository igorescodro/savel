package com.escodro.savel.data.local.di

import com.escodro.savel.data.local.FirestoreDatabase
import com.escodro.savel.data.local.dao.ArtistDao
import com.escodro.savel.data.local.mapper.ArtistMapper
import com.escodro.savel.data.local.mapper.ExternalResourceMapper
import com.escodro.savel.data.repository.datasource.StoreArtistDataSource
import com.google.cloud.firestore.Firestore
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localModule =
    module(createdAtStart = true) {
        singleOf(::FirestoreDatabase)
        single<Firestore> { get<FirestoreDatabase>().initialize() }

        // DAOs
        factoryOf(::ArtistDao) bind StoreArtistDataSource::class

        // Mappers
        factoryOf(::ArtistMapper)
        factoryOf(::ExternalResourceMapper)
    }
