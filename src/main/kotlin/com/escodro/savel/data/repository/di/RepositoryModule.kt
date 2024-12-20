package com.escodro.savel.data.repository.di

import com.escodro.savel.data.repository.ArtistRepositoryImpl
import com.escodro.savel.domain.repository.ArtistRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule =
    module {
        singleOf(::ArtistRepositoryImpl) bind ArtistRepository::class
    }
