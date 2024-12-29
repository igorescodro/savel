package com.escodro.savel.data.local.di

import com.escodro.savel.data.local.FirestoreDatabase
import com.google.cloud.firestore.Firestore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val localModule =
    module(createdAtStart = true) {
        singleOf(::FirestoreDatabase)
        single<Firestore> { get<FirestoreDatabase>().initialize() }
    }
