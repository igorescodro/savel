package com.escodro.savel.data.local.model

import com.escodro.savel.core.model.provider.ExternalProvider
import com.google.cloud.firestore.annotation.PropertyName

data class ExternalResource(
    @get:PropertyName("provider") val provider: ExternalProvider? = null,
    @get:PropertyName("id") val id: String? = null,
    @get:PropertyName("url") val url: String? = null,
)
