package com.escodro.savel.data.repository.model

import com.escodro.savel.core.model.provider.ExternalProvider
import kotlinx.datetime.Instant

data class Token(
    val value: String,
    val provider: ExternalProvider,
    val expiresAt: Instant,
)
