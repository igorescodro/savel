package com.escodro.savel.service

import com.escodro.savel.service.di.savelModule
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    install(Koin) {
        modules(savelModule)
    }
    configureRouting()
}
