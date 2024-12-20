package com.escodro.savel.repository.fake

import com.escodro.savel.data.repository.datasource.SaveTokenDataSource
import com.escodro.savel.data.repository.model.Token

internal class SaveTokenDataSourceFake : SaveTokenDataSource {
    var token: Token? = null

    override suspend fun saveToken(token: Token) {
        this.token = token
    }

    override suspend fun getToken(): Token? = token

    fun clear() {
        token = null
    }
}
