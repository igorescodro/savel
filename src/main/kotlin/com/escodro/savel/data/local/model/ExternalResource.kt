package com.escodro.savel.data.local.model

import com.escodro.savel.core.model.provider.ExternalProvider

data class ExternalResource(
    val provider: ExternalProvider? = null,
    val id: String? = null,
    val url: String? = null,
)
