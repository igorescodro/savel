package com.escodro.savel.service.di

import com.escodro.savel.service.route.RouteProvider
import com.escodro.savel.service.route.SearchRouteProvider
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val serviceModule =
    module {

        factoryOf(::SearchRouteProvider) bind RouteProvider::class
    }
