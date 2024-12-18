package com.escodro.service.di

import com.escodro.data.repository.di.repositoryModule
import com.escodro.domain.di.domainModule
import com.escodro.remote.di.remoteModule
import org.koin.dsl.module

internal val savelModule = module {
    includes(
        domainModule,
        repositoryModule,
        remoteModule,
    )
}