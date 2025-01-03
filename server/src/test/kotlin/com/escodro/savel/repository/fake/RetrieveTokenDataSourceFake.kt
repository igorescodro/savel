package com.escodro.savel.repository.fake

import com.escodro.savel.data.repository.datasource.RetrieveTokenDataSource
import com.escodro.savel.data.repository.model.Token

internal class RetrieveTokenDataSourceFake : RetrieveTokenDataSource {
    var token: Token? = null

    override suspend fun refreshToken(): Token? = token

    fun clear() {
        token = null
    }
}
