package com.escodro.savel.data.memory.di

import com.escodro.savel.data.memory.MemoryStoreToken
import com.escodro.savel.data.repository.datasource.StoreTokenDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val memoryModule =
    module {
        singleOf(::MemoryStoreToken) bind StoreTokenDataSource::class
    }
