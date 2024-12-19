package com.escodro.service

import com.escodro.service.di.savelModule
import io.ktor.server.application.*
import io.ktor.server.netty.*
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
