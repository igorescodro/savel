package com.escodro.savel.data.local.mapper

import com.escodro.savel.core.model.artist.ExternalResource as CoreExternalResource
import com.escodro.savel.data.local.model.ExternalResource as LocalExternalResource

internal class ExternalResourceMapper {
    fun toLocal(externalResourceList: List<CoreExternalResource>?): List<LocalExternalResource>? =
        externalResourceList?.map { toLocal(it) }

    private fun toLocal(externalResource: CoreExternalResource): LocalExternalResource =
        LocalExternalResource(
            provider = externalResource.provider,
            id = externalResource.id,
            url = externalResource.url,
        )

    fun toCore(externalResourceList: List<LocalExternalResource>?): List<CoreExternalResource>? =
        externalResourceList?.mapNotNull { toCore(it) }

    private fun toCore(externalResource: LocalExternalResource): CoreExternalResource? {
        if (externalResource.provider == null || externalResource.id == null) {
            return null
        }
        return CoreExternalResource(
            provider = externalResource.provider,
            id = externalResource.id,
            url = externalResource.url,
        )
    }
}
