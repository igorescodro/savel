package com.escodro.savel.library.datetime.di

import com.escodro.savel.library.datetime.DateTimeProvider
import com.escodro.savel.library.datetime.DateTimeProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dateTimeModule =
    module {
        singleOf(::DateTimeProviderImpl) bind DateTimeProvider::class
    }
