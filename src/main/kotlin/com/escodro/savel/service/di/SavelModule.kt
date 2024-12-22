package com.escodro.savel.service.di

import com.escodro.savel.data.memory.di.memoryModule
import com.escodro.savel.data.remote.di.remoteModule
import com.escodro.savel.data.repository.di.repositoryModule
import com.escodro.savel.domain.di.domainModule
import com.escodro.savel.library.datetime.di.dateTimeModule
import org.koin.dsl.module

internal val savelModule =
    module {
        includes(
            serviceModule,
            domainModule,
            repositoryModule,
            remoteModule,
            memoryModule,
            dateTimeModule,
        )
    }
