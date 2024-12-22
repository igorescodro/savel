package com.escodro.savel.service.di

import com.escodro.savel.service.route.RouteProvider
import com.escodro.savel.service.route.SearchRouteProvider
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.HoconApplicationConfig
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val serviceModule =
    module {
        factoryOf(::SearchRouteProvider) bind RouteProvider::class

        single<HoconApplicationConfig> {
            HoconApplicationConfig(ConfigFactory.load())
        }
    }
