package com.escodro.savel.service.di

import com.escodro.savel.data.repository.di.repositoryModule
import com.escodro.savel.domain.di.domainModule
import com.escodro.savel.remote.di.remoteModule
import org.koin.dsl.module

internal val savelModule = module {
    includes(
        serviceModule,
        domainModule,
        repositoryModule,
        remoteModule,
    )
}