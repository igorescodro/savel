package com.escodro.savel.data.local

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import io.ktor.server.config.HoconApplicationConfig

internal class FirestoreDatabase(
    private val config: HoconApplicationConfig,
) {
    fun initialize(): Firestore {
        val credentials = GoogleCredentials.getApplicationDefault()
        val projectId = config.property("service.google.projectId").getString()
        val options =
            FirebaseOptions
                .builder()
                .setCredentials(credentials)
                .setProjectId(projectId)
                .build()

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options)
        }

        return FirestoreClient.getFirestore()
    }
}
