package com.escodro.savel.data.memory

import com.escodro.savel.data.repository.datasource.StoreTokenDataSource
import com.escodro.savel.data.repository.model.Token

internal class MemoryStoreToken : StoreTokenDataSource {
    private var token: Token? = null

    override suspend fun saveToken(token: Token) {
        this.token = token
    }

    override suspend fun getToken(): Token? = token
}
