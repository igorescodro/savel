package com.escodro.data.repository.di

import com.escodro.data.repository.ArtistRepositoryImpl
import com.escodro.domain.repository.ArtistRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::ArtistRepositoryImpl) bind ArtistRepository::class
}