package com.escodro.savel.repository.fake

import com.escodro.savel.data.repository.datasource.StoreTokenDataSource
import com.escodro.savel.data.repository.model.Token

internal class StoreTokenDataSourceFake : StoreTokenDataSource {
    var token: Token? = null

    override suspend fun saveToken(token: Token) {
        this.token = token
    }

    override suspend fun getToken(): Token? = token

    fun clear() {
        token = null
    }
}
