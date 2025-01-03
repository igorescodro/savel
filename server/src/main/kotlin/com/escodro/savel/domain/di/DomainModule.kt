package com.escodro.savel.domain.di

import com.escodro.savel.domain.usecase.artist.GetArtistById
import com.escodro.savel.domain.usecase.search.SearchArtist
import com.escodro.savel.domain.usecase.token.RefreshTokens
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        factoryOf(::SearchArtist)
        factoryOf(::RefreshTokens)
        factoryOf(::GetArtistById)
    }
