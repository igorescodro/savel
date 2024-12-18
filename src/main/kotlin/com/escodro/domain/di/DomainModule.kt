package com.escodro.domain.di

import com.escodro.domain.usecase.SearchArtist
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    factoryOf(::SearchArtist)
}