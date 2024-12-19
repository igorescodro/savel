package com.escodro.savel.domain.di

import com.escodro.savel.domain.usecase.SearchArtist
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    factoryOf(::SearchArtist)
}